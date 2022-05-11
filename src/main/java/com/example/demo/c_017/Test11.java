package com.example.demo.c_017;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore信号量   可以设置同时访问的线程数量
 */
public class Test11 {

    public static void main(String[] args) {
       /* Semaphore sp=new Semaphore(2,true);*/
        Semaphore sp=new Semaphore(2);

        new Thread(()->{
            try {
                sp.acquire();
                System.out.println("T1....start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("T1....end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sp.release();
        },"thread1").start();

        new Thread(()->{
            try {
                sp.acquire();
                System.out.println("T2....start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("T2....end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sp.release();
        },"thread2").start();

        new Thread(()->{
            try {
                sp.acquire();
                System.out.println("T3....start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("T3....end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sp.release();
        },"thread3").start();


    }
}
