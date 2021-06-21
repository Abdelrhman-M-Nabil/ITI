package com.company;

public class Main {

    public static void main(String[] args) {
	new SimpleThread("Thread object 1").start();
	new SimpleThread("Thread object 2").start();
	SimpleThread RO = new SimpleThread("Runnable object");
	new Thread(RO).start();

    }
}
