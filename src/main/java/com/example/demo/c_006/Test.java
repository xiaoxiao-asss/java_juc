package com.example.demo.c_006;

public class Test implements Runnable{

    private int count=10;

    @Override
    public  void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+" count:"+count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Test(),"thread"+i).start();
        }
    }

}
