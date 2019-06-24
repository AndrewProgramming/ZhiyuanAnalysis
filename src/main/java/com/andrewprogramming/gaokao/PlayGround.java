package com.andrewprogramming.gaokao;

import com.andrewprogramming.gaokao.util.Util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class F {
    public static void main( String ... args ) {
        String [] status =  { "EXECUTING", "READY-SUSPENDED", "CREATED" };
        int [] pids =  {123, 34, 1231 };
        int i = 0;
        for( String s : status ) {
            System.out.printf("Process PID: %-5d Status : %s%n", pids[i++], s);
        }
    }
}