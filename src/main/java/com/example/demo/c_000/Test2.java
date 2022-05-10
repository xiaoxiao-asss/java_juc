package com.example.demo.c_000;

public class Test2 {

    static class C1 extends Thread {

        @Override
        public void run() {
            System.out.println("thread run.....");
        }
    }


    static class C2 implements Runnable {

        @Override
        public void run() {
            System.out.println("runnable run.......");
        }
    }


    public static void main(String[] args) {
        new C1().start();
        new Thread(new C2()).start();

        new Thread(()-> System.out.println("hello ")).start();
    }
}
