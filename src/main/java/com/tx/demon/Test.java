package com.tx.demon;

import redis.clients.jedis.Jedis;


public class Test implements Runnable {

    public static int ticketNum = 10;

    //    synchronized(this);
    @Override
    public synchronized void run() {
        while (ticketNum >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buy();
        }
    }

    public  void buy() {
        System.out.println(Thread.currentThread().getName()
                + "--->拿到了第" + ticketNum + "张票");
        ticketNum--;
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test, "小明").start();
        new Thread(test, "小红").start();
        new Thread(test, "小星").start();
    }
}
