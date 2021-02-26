package com.tx.demon;

import org.junit.platform.commons.annotation.Testable;

public class Test1 extends Thread{
    private int ticketNum=10;

    @Override
    public void run() {
        while (ticketNum>=0){
            System.out.println(Thread.currentThread().getName()
                    +"--->拿到了第"+ticketNum+"张票");
            ticketNum--;
        }
    }
    public static void main(String[] args){
        Test1 t1=new Test1();
        Test1 t2=new Test1();
        Test1 t3=new Test1();
        t1.setName("小明");
        t2.setName("小红");
        t3.setName("小强");
        t1.start();
        t2.start();
        t3.start();
    }
}
