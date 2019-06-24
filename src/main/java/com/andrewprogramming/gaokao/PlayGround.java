//package com.andrewprogramming.gaokao;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//public class PlayGround {
//    public static void main(String[] args) {
//
//        Map<String, String> ldapContent = new HashMap<String, String>();
//        ldapContent.put("1","清华");
//        ldapContent.put("2","北大");
//
//        try {
//            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
//
//            ObjectOutputStream o = new ObjectOutputStream(f);
//
//            // Write objects to file
//            o.writeObject(ldapContent);
//
//            o.close();
//            f.close();
//
//            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
//            ObjectInputStream oi = new ObjectInputStream(fi);
//
//            // Read objects
//            HashMap<String,String> map = (HashMap<String,String>) oi.readObject();
//
//            System.out.println(map);
//            System.out.println(map.get("1"));
//
//            oi.close();
//            fi.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }//        Properties properties = new Properties();
////
////        for (Map.Entry<String,String> entry : ldapContent.entrySet()) {
////            properties.put(entry.getKey(), entry.getValue());
////        }
////
////        try {
////            properties.store(new FileOutputStream("data.properties"), null);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////
////
////
////        Map<String, String> ldapContent1 = new HashMap<String, String>();
////        Properties properties1 = new Properties();
////        try {
////            properties1.load(new FileInputStream("data.properties"));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        for (String key : properties1.stringPropertyNames()) {
////            ldapContent1.put(key, properties1.get(key).toString());
////        }
//    }
//}
