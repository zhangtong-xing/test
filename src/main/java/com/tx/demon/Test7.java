package com.tx.demon;

public class Test7 {
    public static void main(String[] args) {
        Test11 test = new Test11();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("a线程");
                test.print();
            }
        }, "a线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("b线程");
                test.print();
            }
        }, "b线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("c线程");
                test.print();
            }
        }, "c线程").start();


    }
}

class Test11 {
    private int count = 1;

    public synchronized void print() {
        for (int i = 1; i <= 3; i++) {
            switch (count) {
                case 1:
                    System.out.println("A");
                    count = 2;
                    break;
                case 2:
                    System.out.println("B");
                    count = 3;
                    break;
                case 3:
                    System.out.println("C");
                    count = 1;
                    break;
            }
        }


    }

    public synchronized void printA() {
        for (int i = 1; i <= 5; i++) {
            if (count != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            count = 2;
            this.notifyAll();
        }
    }

    public synchronized void printB() {
        for (int i = 1; i <= 5; i++) {
            if (count != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            count = 3;
            this.notifyAll();
        }
    }

    public synchronized void printC() {
        for (int i = 1; i <= 5; i++) {
            if (count != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            count = 1;
            this.notifyAll();
        }
    }

}


