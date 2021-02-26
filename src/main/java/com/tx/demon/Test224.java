package com.tx.demon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test224 {
    /**
     * 编号
     */
    private int id;
    /**
     * 牌名，例如红桃3，梅花10等等
     */
    private String name;

    public Test224(int id) {
        this.id = id;
    }

    public Test224() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) throws Exception{
        //原排好的序列
        List<Test224> cards=new ArrayList<>(52);
        //给牌赋值
        //可以根据id去数据库查询具体牌是什么牌
        for (int i=1;i<=52;i++){
            Test224 test=new Test224(i);
            cards.add(test);
        }
        Collections.shuffle(cards);
        //人数
        int mans=3;
        //每个人牌数量
        int count=cards.size()/mans;
        for (int i=1;i<=mans;i++){
            System.out.print("此人牌id为：");
            for (int j=(i-1)*count+1;j<=i*count;j++){
                System.out.print(cards.get(j).getId()+" ");
            }
            System.out.println();
        }

    }
}

