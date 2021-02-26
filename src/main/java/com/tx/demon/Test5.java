package com.tx.demon;

public class Test5 {
    public static void main(String[] args){
        Box box=new Box();
        Producer1 producer1=new Producer1(box);
        Customer customer=new Customer(box);
        Thread thread=new Thread(customer);
        producer1.start();
        thread.start();
    }


}

class Box{
    private int id;
    private boolean state=false;
    //放牛奶
    public synchronized void putMilk(int id){
        if (state){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.id = id;
        System.out.println("投递id为"+id+"的牛奶");
        state=true;
        notifyAll();
    }
    //取牛奶
    public synchronized void getMilk(){
        if (!state){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了id为"+id+"的牛奶");
        this.state=false;
        notifyAll();
    }
}
class Producer1 extends Thread{
    private Box box;
    public Producer1(Box box){
        this.box=box;
    }

    @Override
    public void run(){
        for (int i=0;i<=10;i++){
            box.putMilk(i);
        }
    }
}
class Customer implements Runnable{
    private Box boxl;
    public Customer(Box box){
        this.boxl=box;
    }

    @Override
    public void run() {
        while (true){
            boxl.getMilk();
        }
    }
}
