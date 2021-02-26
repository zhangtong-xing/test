package com.tx.demon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test6 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1("1");
        Thread1 t2 = new Thread1("2");
        Thread1 t3 = new Thread1("3");

        try {
            t1.start();
//            t1.join();
            t2.start();
//            t2.join();
            t3.start();
//            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

class Thread1 extends Thread {
    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
//        try {
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(this.getName() + "线程在运行");
    }
}
