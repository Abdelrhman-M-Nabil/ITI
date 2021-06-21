package com.company;

public class SimpleRunThread implements Runnable {
    String name;

    public SimpleRunThread(String name) {
        this.name = name;
    }
    @Override
    public void run(){
        for (int i =0 ; i<20 ; i++){
            System.out.println(i + " " + name);
            try{
                Thread.sleep(1000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Done"+name);
    }
}
