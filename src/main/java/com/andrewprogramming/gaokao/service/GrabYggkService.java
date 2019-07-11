package com.andrewprogramming.gaokao.service;

import com.andrewprogramming.gaokao.dao.YggkMajorSatisfyRepository;
import com.andrewprogramming.gaokao.dao.YggkSchoolRepository;
import com.andrewprogramming.gaokao.dao.YggkSchoolSatisfyRepository;
import com.andrewprogramming.gaokao.entity.YggkMajorSatisfy;
import com.andrewprogramming.gaokao.entity.YggkSchool;
import com.andrewprogramming.gaokao.entity.YggkSchoolSatisfy;
import com.andrewprogramming.gaokao.util.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.*;

@org.springframework.stereotype.Service
public class GrabYggkService {
    private static final Logger logger = LogManager.getLogger(GrabYggkService.class);
    private StringBuilder sb = new StringBuilder();

    @Autowired
    private YggkSchoolRepository yggkSchoolRepository;

    @Autowired
    private YggkSchoolSatisfyRepository yggkSchoolSatisfyRepository;

    @Autowired
    private YggkMajorSatisfyRepository yggkMajorSatisfyRepository;

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

    public void grabYggkSchoolInfo() {

        int START = 0;
        int END = 2740;


        List<List<String>> trList = new ArrayList<>();


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
                    ArrayList<String> tdList = new ArrayList<>();
                    for (int j = 0; j < tds.size(); j++) {
                        String text = tds.get(j).text();
                        if (j == 5) {//985,211
                            if (text.equals("985  211")) {
                                text = "985/211";
                            } else if (text.equals(" 985")) {
                                text = "985";
                            } else if (text.equals(" 211")) {
                                text = "211";
                            } else {
                                text = "";
                            }
                        }
                        if (j == 6) {//有没有研究生院
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
                        tdList.add(text);

                    }
                    trList.add(tdList);
                    logger.debug(sb.toString());
                }
            } catch (SocketTimeoutException e) {
                logger.error(e);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

//        savingToCSVFile("yggk.csv", sb);
        wirteObjectToDB(trList);
    }


    @Transactional
    public void wirteObjectToDB(List<List<String>> trList) {
        List<YggkSchool> schoolList = new ArrayList<>();

        try {
            for (int i = 0; i < trList.size(); i++) {
                if (!trList.get(i).isEmpty()) {
                    YggkSchool yggkSchoolItem = new YggkSchool();

                    yggkSchoolItem.setName(trList.get(i).get(0));
                    yggkSchoolItem.setCity(trList.get(i).get(1));
                    yggkSchoolItem.setBelong(trList.get(i).get(2));
                    yggkSchoolItem.setType(trList.get(i).get(3));
                    yggkSchoolItem.setLevel(trList.get(i).get(4));
                    yggkSchoolItem.setFeature(trList.get(i).get(5));
                    yggkSchoolItem.setYjsy(trList.get(i).get(6));
                    yggkSchoolItem.setSatisfy(trList.get(i).get(7));
                    schoolList.add(yggkSchoolItem);
                    if (schoolList.size() < 100 || schoolList.size() % 100 == 0) {
                        logger.info("Saving elements count:" + schoolList.size());
                        yggkSchoolRepository.saveAll(schoolList);
                        logger.info("Successfully writing data to Database!");
                    }
                }


            }

        } catch (Exception ex) {
            logger.error(ex);
        }

    }


    private static void savingToCSVFile(String fileName, StringBuilder sb) {
        PrintWriter printWriter = null;
        try {
            FileOutputStream fo = new FileOutputStream(new File(fileName), true);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "GBK");
            printWriter = new PrintWriter(osw);
            printWriter.write(sb.toString());
            logger.info("Successfully writing data to " + fileName);


        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }

    }

    public void grabYggkSchoolSatisfy() {
        int START = 0;
        int END = 20;

        List<List<String>> trList = new ArrayList<>();

        try {
            for (int counter = START; counter <= END; counter += 20) {
                String url = "https://gaokao.chsi.com.cn/zyk/pub/myd/schAppraisalTop.action?start=" + counter;
                logger.info("Processing url:" + url);
                Document doc = null;

                doc = Util.sendJsoupRequest(url);
                Elements trs = doc.select("tbody").select("tr");


                for (int i = 0; i < trs.size(); i++) {
                    Elements tds = trs.get(i).select("td");
                    ArrayList<String> tdList = new ArrayList<>();
                    for (int j = 0; j < tds.size(); j++) {
                        String text = tds.get(j).text();
                        tdList.add(text);
                    }
                    trList.add(tdList);
                }
            }


            List<YggkSchoolSatisfy> schoolSatisfyList = new ArrayList<>();
            for (int i = 0; i < trList.size(); i++) {
                if (trList.get(i).size() == 6) {
                    YggkSchoolSatisfy item = new YggkSchoolSatisfy();

                    item.setName(trList.get(i).get(0));
                    item.setCity(trList.get(i).get(1));
                    item.setTotalSatisfy(trList.get(i).get(2));
                    item.setEnvSatisfy(trList.get(i).get(3));
                    item.setLifeSatisfy(trList.get(i).get(4));

                    schoolSatisfyList.add(item);
                    if (schoolSatisfyList.size() < 100 || schoolSatisfyList.size() % 100 == 0) {
                        logger.info("Saving elements count:" + schoolSatisfyList.size());
                        yggkSchoolSatisfyRepository.saveAll(schoolSatisfyList);
                        logger.info("Successfully writing data to Database!");
                    }
                }
            }
            logger.info("stop");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gragSchoolMajorInfo() {
        int START = 0;
        int END = 100;

        List<List<String>> trList = new ArrayList<>();

        try {
            for (int counter = START; counter <= END; counter += 20) {
                String url = "https://gaokao.chsi.com.cn/zyk/pub/myd/specAppraisalTop.action?start=" + counter;
                logger.info("Processing url:" + url);
                Document doc = null;

                doc = Util.sendJsoupRequest(url);
                Elements trs = doc.select(".cnt_table").select("tr");

//                List<List<String>> trList1 = new ArrayList<>();

                for (int i = 0; i < trs.size(); i++) {
                    Elements tds = trs.get(i).select("td");
                    if (tds.size() < 6) continue;
                    String link = tds.get(6).select("a").first().attr("href");


                    String schoolMajorUrl = "https://gaokao.chsi.com.cn/" + link;
                    logger.info("Processing url:" + schoolMajorUrl);
                    Document schoolMajorDoc = Util.sendJsoupRequest(schoolMajorUrl);

                    Element table = schoolMajorDoc.select("#queryResult").select("table").first();
                    Element tbody = table.select("tbody").first();
                    Elements children = tbody.children();
                    for (Element child : children) {
                        List<String> tdList = new LinkedList<>();
                        Elements tds1 = child.children();
                        tdList.add(tds.get(0).text());
                        for (int k = 0; k < tds1.size(); k++) {
                            tdList.add(tds1.get(k).select("td").first().text());
                        }
                        trList.add(tdList);
                    }
                }
            }

            List<YggkMajorSatisfy> majorSatisfyList = new LinkedList<>();

            for (int i = 0; i < trList.size(); i++) {
                YggkMajorSatisfy item = new YggkMajorSatisfy();
                List<String> innerList = trList.get(i);
                for (int j = 0; j < innerList.size(); j++) {
                    item.setSchoolName(innerList.get(0));
                    item.setMajorName(innerList.get(1));
                    item.setTotalSatisfy(innerList.get(2));
                    item.setHardwareSatisfy(innerList.get(3));
                    item.setTeachQualitySatisfy(innerList.get(4));
                    item.setGetJobSatisfy(innerList.get(5));
                }

                majorSatisfyList.add(item);

                if (majorSatisfyList.size() < 100 || majorSatisfyList.size() % 100 == 0) {
                    logger.info("Saving elements count:" + majorSatisfyList.size());
                    yggkMajorSatisfyRepository.saveAll(majorSatisfyList);
                    logger.info("Successfully writing data to Database!");
                }
            }

            logger.info("Finish processing!");
        } catch (Exception ex) {
            logger.error(ex);
            ex.printStackTrace();
        }
    }
}
