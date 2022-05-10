package com.example.demo.c_017;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch可以在一个线程中循环调用countDown消耗指定数量的CountDownLatch
 */
public class Test6  {


    public static void main(String[] args) {
        testCountDownLatch2();
       // testJoin();
    }

    public static void testCountDownLatch2() {
        CountDownLatch cdl=new CountDownLatch(10);
        new Thread(()->{
            for (int i1 = 0; i1 <9; i1++) {
                cdl.countDown();
            }
        },"thread1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cdl.countDown();
        },"thread2").start();

        try {
            cdl.await();   //阻塞，等待CountDownLatch变为0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end latch");
    }
    public static void testCountDownLatch(){


        Thread[] threads=new Thread[100];
        CountDownLatch cdl=new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i]=new Thread(()->{
                System.out.println("start latch"+ finalI);
                int result = 0;
                for (int i1 = 0; i1 < 10000; i1++) {
                    result += i1;
                }
                cdl.countDown();
            });
        }

        Arrays.stream(threads).forEach(item->{
            item.start();
        });
        try {
            cdl.await();   //阻塞，等待CountDownLatch变为0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end latch");
    }


    public static void testJoin(){
        Thread[] threads=new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(()->{
                int result = 0;
                for (int i1 = 0; i1 < 10000; i1++) {
                    result += i1;
                }
            });
        }

        Arrays.stream(threads).forEach(item-> {
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("end join");
    }
}
