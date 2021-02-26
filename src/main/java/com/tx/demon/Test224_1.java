package com.tx.demon;

public class Test224_1 {
    public static void main(String[] args) {
        System.out.println("微信红包算法：");
        dealRedPackage(100,7);
    }

    //请补充下列函数内容
    public static void dealRedPackage(double money,int n){
        double tem=money;
        for(int i=1;i<=(n-1);i++){
            tem/=2;
            System.out.println("第"+i+"个人抢的的红包为:"+tem);
            money-=tem;
        }
        System.out.println("第"+n+"个人抢的红包为:"+money);
    }
}
