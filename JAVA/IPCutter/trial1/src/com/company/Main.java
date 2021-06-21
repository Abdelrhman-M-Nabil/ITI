package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String IP = "192.168.1.1";
        IPCutter c = new IPCutter(IP);
        int[] n = c.cutIP();
        for ( Integer i : n) {
            System.out.print(Integer.toString(i)+"\n");
        }
        System.out.println("\n");
        c.setVar("192.168.20.115");
        System.out.println("Your IP is "+c.getVar());
        n = c.cutIP();
        for ( Integer i : n) {
            System.out.print(Integer.toString(i) + "\n");
        }

    }
}
