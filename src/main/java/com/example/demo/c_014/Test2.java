package com.example.demo.c_014;

import java.util.concurrent.TimeUnit;

public class Test2 {

    /*final*/ Object object=new Object();

    public void m() {
        synchronized (object){

            while(true){

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }

    }

    public void n() {

        synchronized (object){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("n.......");
        }
    }

    public static void main(String[] args) {
        Test2 test2=new Test2();
        new Thread(test2::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(test2::n,"t2").start();
        test2.object=new Object(); //锁对象发生改变，所以t2线程得以执行，如果注释掉这句话，线程2将永远得不到执行机会

    }



}
