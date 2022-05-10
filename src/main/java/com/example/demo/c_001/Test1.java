package com.example.demo.c_001;

public class Test1 {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()-> new Test1().test(),i+"").start();
        }
    }

    static int count=100;
    Object obj=new Object();

    public void test(){
        synchronized (obj){ //任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName()+":count="+count);
        }
    }
}
