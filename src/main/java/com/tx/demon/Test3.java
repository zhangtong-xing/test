package com.tx.demon;

public class Test3 {
    static class impl2 implements lambdar {

        @Override
        public void lam() {
            System.out.println("测试拉曼大2");
        }
    }

    public static void main(String[] args) {
        lambdar l = new impl();
        l.lam();

        l = new impl2();
        l.lam();

        class impl3 implements lambdar {

            @Override
            public void lam() {
                System.out.println("测试拉曼大3");
            }
        }

        l = new impl3();
        l.lam();

        l=new lambdar() {
            @Override
            public void lam() {
                System.out.println("测试拉曼大4");
            }
        };
        l.lam();

        l=()->{
            System.out.println("测试拉曼大5");
        };
        l.lam();
    }
}

interface lambdar {
    void lam();
}

class impl implements lambdar {

    @Override
    public void lam() {
        System.out.println("测试拉曼大");
    }
}
