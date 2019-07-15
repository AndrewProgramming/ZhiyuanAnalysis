package com.andrewprogramming.gaokao.util;

import com.andrewprogramming.gaokao.entity.SchoolDetail;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    private final String USER_AGENT = "Mozilla/5.0";

    private static final Logger logger = LogManager.getLogger(Util.class);



    public static void savingMapToFile(Map map, String fileName) {
        try {
            FileOutputStream f = new FileOutputStream(fileName, true);

            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(map);

            o.close();
            f.close();

            logger.info("Successfully write data to " + fileName);

        } catch (FileNotFoundException e) {
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("Error initializing stream");
        }
    }

    public static HashMap<String, String> readingMapFromFile(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream oi = null;

        try {
            fi = new FileInputStream(new File(fileName));
            oi = new ObjectInputStream(fi);

            // Read objects
            HashMap<String, String> map = (HashMap<String, String>) oi.readObject();
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                oi.close();
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }


    public static Document sendJsoupRequest(String url) throws Exception {
        return Jsoup.connect(url).get();

    }
}
