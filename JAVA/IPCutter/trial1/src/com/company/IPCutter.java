package com.company;

import java.util.Arrays;

public class IPCutter {
    String var;

    public IPCutter(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        System.out.println("New IP was set");
        this.var = var;
    }
    public int[] cutIP(){
        int i =0;
        int intparts[] = new int[4];
        String [] parts = var.split("\\.");
        if (parts.length != 4){
            System.out.println("error in input");
            return null;
        }
        else{
            System.out.println("the cut version of your IP is");
            for (String v : parts){
                intparts [i] = Integer.parseInt(v);
                i++;


            }
            return intparts ;
        }
    }
}
