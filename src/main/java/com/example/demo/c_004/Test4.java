package com.example.demo.c_004;

public class Test4 {

   static int count=100;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
            new Thread(()-> new Test4().test3()).start();
    }

    public void test3() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName()+"::count::"+count);
        }
    }
}
