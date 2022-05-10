package com.example.demo.c_009;

import java.util.concurrent.TimeUnit;

/**
 * 冲入
 */
public class Test {

    synchronized  void m(){
        System.out.println("m start...");

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n();
        System.out.println("m end...");
    }

    synchronized void n(){
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("n .....");
    }

    public static void main(String[] args) {
        Test test=new Test();
        new Thread(test::m).start();
    }
}
