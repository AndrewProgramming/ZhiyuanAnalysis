package com.andrewprogramming.gaokao.huananligong;

import com.andrewprogramming.gaokao.entity.Huananligong;
import com.andrewprogramming.gaokao.entity.School;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
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
            List<Huananligong> list = new ArrayList<>();
            for (int i = 0; i < raw.size(); i++) {
                Huananligong item = gson.fromJson(raw.get(i), Huananligong.class);
                list.add(item);
            }

            for (Huananligong item : list) {
//                System.out.println(map.ge);
                if (item.getSpname().startsWith("软件") || item.getSpname().startsWith("自动化") || item.getSpname().startsWith("计算机") || item.getSpname().startsWith("电子信息类")) {
                    System.out.println(item.getSpname() + "," + "最低排名:" + item.getMin_section() + "," + "最低分:" + item.getMin() + "," + "最高分:" + item.getMax() + "," + "平均分:" + item.getAverage());
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

        String url_2018 = "https://static-data.eol.cn/www/2.0/schoolspecialindex/2018/105/44/1/1.json";
        String url_2017 = "https://static-data.eol.cn/www/2.0/schoolspecialindex/2017/105/44/1/1.json";
        String url_2016 = "https://static-data.eol.cn/www/2.0/schoolspecialindex/2016/105/44/1/1.json";
        String url_2015 = "https://static-data.eol.cn/www/2.0/schoolspecialindex/2015/105/44/1/1.json";

        try {
//            sendGet(url_2018);
//            sendGet(url_2017);
//            sendGet(url_2016);
//            sendGet(url_2015);
//
//            System.out.println("===北京邮电大学===");
//            System.out.println("---2018年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2018/48/44/1/1.json");
//            System.out.println("---2017年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2017/48/44/1/1.json");
//            System.out.println("---2016年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2016/48/44/1/1.json");
//            System.out.println("---2015年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2015/48/44/1/1.json");
//
//
//            System.out.println("===北京航空航天大学===");
//            System.out.println("---2018年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2018/47/44/1/1.json");
//            System.out.println("---2017年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2017/47/44/1/1.json");
//            System.out.println("---2016年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2016/47/44/1/1.json");
//            System.out.println("---2015年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2015/47/44/1/1.json");
//
//
//            System.out.println("===中山大学===");
//            System.out.println("---2018年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2018/104/44/1/1.json");
//            System.out.println("---2017年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2017/104/44/1/1.json");
//            System.out.println("---2016年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2016/104/44/1/1.json");
//            System.out.println("---2015年---");
//            sendGet("https://static-data.eol.cn/www/2.0/schoolspecialindex/2015/104/44/1/1.json");

            System.out.println("------school-------");
            for (int i = 1; i < 200; i++) {
                for (int j = 2015; j <= 2018; j++) {
                    String tempUrl = "https://static-data.eol.cn/www/2.0/schoolspecialindex/" + j + "/" + i + "/44/1/1.json";
                    sendGet(tempUrl);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/initMap")
    private void initMap() throws Exception {
        for (int i = 1000; i < 1500; i++) {
            String item = "https://static-data.eol.cn/www/school/" + i + "/info.json";
            initSchoolIdNameMap(item);
        }
        Util.savingMapToFile(map, "SchoolIdNameMap.txt");

    }

    public JsonArray parse(String jsonLine) {
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("data");
        JsonArray jarray = jobject.getAsJsonArray("item");
        return jarray;
    }

}
