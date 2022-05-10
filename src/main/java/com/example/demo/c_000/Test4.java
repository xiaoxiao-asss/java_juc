package com.example.demo.c_000;

import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {
        Thread thread=new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getState());

    }
}
