package com.andrewprogramming.gaokao.service;

import com.andrewprogramming.gaokao.controller.Controller;
import com.andrewprogramming.gaokao.entity.School;
import com.andrewprogramming.gaokao.util.Util;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;

@org.springframework.stereotype.Service
public class Service {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private StringBuilder sb = new StringBuilder();
    {
        sb.append("院校名称,");
        sb.append("院校所在地,");
        sb.append("院校隶属,");
        sb.append("院校类型,");
        sb.append("学历层次,");
        sb.append("院校特性,");
        sb.append("是否有研究生院,");
        sb.append("满意度");
        sb.append("\n");
    }

    public void writeYggkDataToCSV(String fileName) {

        int END = 40;
        int START = 0;

        for (int counter = START; counter <= END; counter += 20) {
            String url = "https://gaokao.chsi.com.cn/sch/search--ss-on,searchType-1,option-qg,start-" + counter + ".dhtml";
            logger.info("Processing url:" + url);
            Document doc = null;
            try {
                doc = Util.sendJsoupRequest(url);
                Element table = doc.select("div.ch-table").first();

                Elements trs = doc.select("table").select("tr");
                for (int i = 0; i < trs.size(); i++) {
                    Elements tds = trs.get(i).select("td");
                    for (int j = 0; j < tds.size(); j++) {
                        String text = tds.get(j).text();
                        if (j == 5) {//985,211
                            if (text.equals("985  211")) {
                                text = "985/211";
                            } else if (text.equals("985")) {
                                text = "985";
                            } else if (text.equals("211")) {
                                text = "211";
                            } else {
                                text = "";
                            }
                        }
                        if (j == 6) {
                            if (text.equals("\uE664")) {
                                text = "有";
                            }
                        }
                        if (j == tds.size() - 1) {
                            sb.append(text);
                            sb.append("\n");
                        } else {
                            sb.append(text + ",");
                        }
                    }

                    logger.info(sb.toString());
                }
            } catch (SocketTimeoutException e) {
                logger.error(e);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        Util.savingToFile(fileName, sb);
    }


}
