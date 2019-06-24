package com.andrewprogramming.gaokao.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public static void savingMapToFile(Map map, String fileName) {
        try {
            FileOutputStream f = new FileOutputStream(fileName, true);

            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(map);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
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
            System.out.println(map);


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
}
