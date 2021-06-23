package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            InputStreamReader re = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(re);

            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AI\\1-Technical\\09-Java&UML\\cons.txt"));


            String line = "";
            int flag = 0;
            do {


                try {
                    System.out.println("enter line");
                    line = br.readLine();
                    bw.write(line + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
            }
            if (line.equals("stop")){flag = 1;}

        }while (flag!=1);
            bw.close();

    }catch (IOException e) {
        e.printStackTrace();
}}}