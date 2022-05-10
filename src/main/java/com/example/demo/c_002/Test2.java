package com.example.demo.c_002;

public class Test2 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> new Test2().test(),i+"").start();
        }
    }

    static int count=100;

    public void test(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+":count="+count);
        }
    }
}
