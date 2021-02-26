package com.tx.demon;

import java.util.Scanner;

public class Test224_2 {
    public static void main(String[] args){
        String s="the sky is blue";
        String tem[]=s.split(" ");
        String newS="";
        for (int i=tem.length-1;i>=0;i--){
            newS=newS+" "+tem[i];
        }
        System.out.println(newS);
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.next();
    }
}
