package com.example.demo.c_017;


import java.util.concurrent.Exchanger;

/**
 *
 */
public class Test12 {

    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger();

        new Thread(()->{
            try {
                String str=exchanger.exchange("a1");
                System.out.println(Thread.currentThread().getName()+" "+str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();


        new Thread(()->{
            try {
                String str=exchanger.exchange("a2");
                System.out.println(Thread.currentThread().getName()+" "+str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
