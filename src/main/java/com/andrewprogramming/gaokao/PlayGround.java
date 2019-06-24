package com.andrewprogramming.gaokao;

import com.andrewprogramming.gaokao.util.Util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PlayGround {
    public static void main(String[] args) {
        Map map=Util.readingMapFromFile("SchoolIdNameMap.txt");
        System.out.println(map.get("31"));



    }
}
