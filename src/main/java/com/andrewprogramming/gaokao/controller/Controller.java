package com.andrewprogramming.gaokao.controller;

import com.andrewprogramming.gaokao.entity.School;
import com.andrewprogramming.gaokao.entity.SchoolDetail;
import com.andrewprogramming.gaokao.service.Service;
import com.andrewprogramming.gaokao.util.Util;
import com.google.gson.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.client.methods.HttpGet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@RestController
public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);


    private static final int START_YEAR = 2015;
    private static final int END_YEAR = 2018;


    private final String USER_AGENT = "Mozilla/5.0";
    private Map<String, String> map = new HashMap<>();
    @Autowired
    private Service service;

    private StringBuilder sb = new StringBuilder();


    {
        sb.append("学校名称,");
        sb.append("年份,");
        sb.append("专业,");
        sb.append("最低排名,");
        sb.append("最低分,");
        sb.append("最高分,");
        sb.append("平均分");
        sb.append("\n");
    }

    // HTTP GET request
    @RequestMapping("/doGet")
    private void sendGet(String tempUrl, String schoolName, int year) throws Exception {


        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(tempUrl);

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
                if (item.getSpname().startsWith("软件") || item.getSpname().startsWith("自动化")
                        || item.getSpname().startsWith("计算机") || item.getSpname().startsWith("电子信息类")) {
                    sb.append(schoolName + ",");
                    sb.append(year + ",");
                    sb.append(item.getSpname() + ",");
                    sb.append(item.getMin_section() + ",");
                    sb.append(item.getMin() + ",");
                    sb.append(item.getMax() + ",");
                    sb.append(item.getAverage() + "");
                    sb.append("\n");
                }
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

            for (int i = 1; i < 500; i++) {
                if (map.get(i + "") == null) continue;
                logger.info("Processing school " + map.get(i + "") + " index:" + i);
                for (int j = START_YEAR; j <= END_YEAR; j++) {
                    String tempUrl = "https://static-data.eol.cn/www/2.0/schoolspecialindex/" + j + "/" + i + "/44/1/1.json";
                    sendGet(tempUrl, map.get(i + ""), j);
                }
                System.out.println();
            }
            Util.savingToFile("data.csv", sb);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/initMap")
    private void initMap() {
        for (int i = 1; i < 2000; i++) {
            String item = "https://static-data.eol.cn/www/school/" + i + "/info.json";
            logger.info("Processing index:" + i);
            try {
                initSchoolIdNameMap(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Util.savingMapToFile(map, "map.txt");


    }

    @RequestMapping("/yggk")
    public void writeYggkToCSV(){
        try {
            service.writeYggkDataToCSV("yggk.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonArray parse(String jsonLine) {
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("data");
        JsonArray jarray = jobject.getAsJsonArray("item");
        return jarray;
    }

}
