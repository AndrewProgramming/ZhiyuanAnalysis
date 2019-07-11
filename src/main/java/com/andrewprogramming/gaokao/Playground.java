package com.andrewprogramming.gaokao;

import com.andrewprogramming.gaokao.util.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class Playground {
    public static void main(String... args) throws Exception {

        String url = "https://gaokao.chsi.com.cn//zyk/pub/myd/specAppraisalTopMore.action?schId=73394518&cc=1";


        Document schoolMajorDoc = Util.sendJsoupRequest(url);


        Element table = schoolMajorDoc.select("#queryResult").select("table").first();
        Element tbody = table.select("tbody").first();
//        Elements trs = tbody.select("tr");
        Elements children = tbody.children();
        for (Element child:children){
            Elements tds = child.children();
            System.out.println(tds.get(0).text());
            for (int i=1;i<tds.size();i++){
                System.out.println(tds.get(i).select("td").first().text());
            }
        }

        System.out.println("Finished!");


    }
}
