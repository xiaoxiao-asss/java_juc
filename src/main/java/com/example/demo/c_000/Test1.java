package com.example.demo.c_000;


import java.util.concurrent.TimeUnit;

public class Test1 {
    private static class C1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a");
            }
        }
    }


    public static void main(String[] args) {
        new C1().start();

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }

    }
}

