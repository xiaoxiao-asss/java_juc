package com.example.demo.c_000;

import java.util.concurrent.TimeUnit;

public class Test3 {

    public static void main(String[] args) {
        //testSleep();
       // testYield();
        testJoin();
    }

    static void testJoin() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("a" + i);
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        Thread thread2=new Thread(() -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("b" + i);
            }
        });

        thread.start();
        thread2.start();
    }

    static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("a" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("b" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }


    static void testSleep() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
