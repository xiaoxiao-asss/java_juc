package com.example.demo.c_003;

public class Test1 {

    private int count=100;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> new Test1().test1()).start();
        }
    }

    public  synchronized void test1(){   //相当于synchronized (this){  }
        count--;
        System.out.println(Thread.currentThread().getName()+"::count::"+count);
    }
}
