package com.example.demo.c_017;

import java.util.concurrent.TimeUnit;

public class Test1 {
    synchronized void m() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) {
                n();
            }

        }
    }

    synchronized void n() {
        System.out.println("n.....");
    }


    public static void main(String[] args) {

        Test1 test1 = new Test1();
        new Thread(test1::m).start();
    }


}
