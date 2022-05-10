package com.example.demo.c_007;

import java.util.concurrent.TimeUnit;

public class Test  {

    public  synchronized  void m(){
        System.out.println("m start......");

        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end......");
    }


    public void n(){
        System.out.println("n 调用");
    }

    public static void main(String[] args) {
        Test test=new Test();
        new Thread(test::m,"t1").start();
        new Thread(test::n,"t2").start();
    }

}
