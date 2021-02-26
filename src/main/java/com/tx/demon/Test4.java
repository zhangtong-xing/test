package com.tx.demon;

public class Test4 {
    public static void main(String[] args){
        Container container=new Container();
        new Producer(container).start();
        new Consumer(container).start();
    }
}
//产品
class Product{
    int id;
    public Product(int id){
        this.id=id;
    }
}
//缓冲区
class Container{
    Product[] products=new Product[10];
    int count=0;

    //生成者加入产品
    public synchronized void add(Product product){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //缓冲区满了就等待
        if (count==10){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没满继续生产
        products[count]=product;
//        System.out.println("缓存区还剩"+(count+1)+"个产品");
        count++;
        //通知消费者可以消费了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Product pop(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //已经没有产品了
        if (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Product product=products[count];
//        System.out.println("缓存区还剩"+(count+1)+"个产品");
        //通知生产者生产
        this.notifyAll();
        return product;
    }


}
class Producer extends Thread{
    Container container;
    public Producer(Container container){
        this.container=container;
    }
    //生产
    @Override
    public void run(){
        for (int i=1;i<=20;i++){
            container.add(new Product(i));
            System.out.println("刚刚生产了id为"+i+"的产品");
        }
    }
}
class Consumer extends Thread{
    Container container;
    public Consumer(Container container){
        this.container=container;
    }
    @Override
    public void run(){
        for (int i=0;i<=20;i++){
            System.out.println("消费了id为"+container.pop().id+"的产品");
        }
    }
}


