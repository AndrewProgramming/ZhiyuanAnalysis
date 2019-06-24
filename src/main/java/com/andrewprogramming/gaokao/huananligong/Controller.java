package com.andrewprogramming.gaokao.huananligong;

import com.andrewprogramming.gaokao.entity.School;
import com.andrewprogramming.gaokao.entity.SchoolDetail;
import com.andrewprogramming.gaokao.util.Util;
import com.google.gson.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.client.methods.HttpGet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@RestController
public class Controller {
    private static final int START_YEAR = 2015;
    private static final int END_YEAR = 2018;

    private static Formatter formatter = new Formatter(System.out);


    private final String USER_AGENT = "Mozilla/5.0";
    private Map<String, String> map = new HashMap<>();

    // HTTP GET request
    @RequestMapping("/doGet")
    private void sendGet(String url) throws Exception {


        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);
//        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode() == 200) {


            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            Gson gson = new Gson();
            JsonArray raw = parse(result.toString());
            List<SchoolDetail> list = new ArrayList<>();
            for (int i = 0; i < raw.size(); i++) {
                SchoolDetail item = gson.fromJson(raw.get(i), SchoolDetail.class);
                list.add(item);
            }

            for (SchoolDetail item : list) {
                if (item.getSpname().startsWith("软件") || item.getSpname().startsWith("自动化") || item.getSpname().startsWith("计算机") || item.getSpname().startsWith("电子信息类")) {
//                    System.out.println(item.getSpname() + "    " + "," + "最低排名:" + item.getMin_section() + "," + "最低分:" + item.getMin() + "," + "最高分:" + item.getMax() + "," + "平均分:" + item.getAverage());
                    System.out.printf("%-15s %-5s %-7s %-7s %-7s %-5s %-5s %-5s %-5s\n", item.getSpname() , "最低排名",item.getMin_section(),"最低分",item.getMin(),"最高分",item.getMax(),"平均分:",item.getAverage());
                }
//            if (isInteger(item.getMin_section(), 10) && Integer.parseInt(item.getMin_section()) >= 9845) {
//                System.out.println(item.getSpname() + "," + "最低排名：" + item.getMin_section() + "," + "最低分" + item.getMin() + "," + "最高分" + item.getMax());            }
            }
        }

    }

    private void initSchoolIdNameMap(String url) throws Exception {


        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);
//        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode() == 200) {

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            Gson gson = new Gson();
            School school = gson.fromJson(result.toString(), School.class);
            map.put(school.getSchool_id(), school.getName());
        }

    }


    @RequestMapping("/doMore")
    public void doMore() {
        try {
            map = Util.readingMapFromFile("map.txt");
            System.out.println(map);
            for (int i = 50; i < 100; i++) {
                System.out.println("###" + map.get(i + "") + "###");
                for (int j = START_YEAR; j <= END_YEAR; j++) {
//                    System.out.println("    -year" + j + "-");
                    formatter.format("%-25s %-5s\n", "year", j);
                    String tempUrl = "https://static-data.eol.cn/www/2.0/schoolspecialindex/" + j + "/" + i + "/44/1/1.json";
                    sendGet(tempUrl);
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/initMap")
    private void initMap() {
        for (int i = 100; i < 200; i++) {
            String item = "https://static-data.eol.cn/www/school/" + i + "/info.json";
            try {
                initSchoolIdNameMap(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Util.savingMapToFile(map, "map.txt");


    }

    public JsonArray parse(String jsonLine) {
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("data");
        JsonArray jarray = jobject.getAsJsonArray("item");
        return jarray;
    }

}
