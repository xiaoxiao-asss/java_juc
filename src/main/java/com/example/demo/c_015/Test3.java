package com.example.demo.c_015;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Test3 {
    static long count1=0L;

    static LongAdder count3 = new LongAdder();


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[500];

        Object obj = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i]= new Thread(() -> {
                for (int i1 = 0; i1 < 100000; i1++) {
                    synchronized (obj) {
                        count1++;
                    }
                }
            });
        }
        long start=System.currentTimeMillis();

        for(Thread t : threads ) t.start();

        for (Thread t : threads) t.join();

        long end=System.currentTimeMillis();

        System.out.println("sync:"+count1+" time:"+(end-start));



        for (int i = 0; i < threads.length; i++) {
            threads[i]= new Thread(() -> {
                for (int i1 = 0; i1 < 100000; i1++) {
                    count3.increment();
                }
            });
        }
        start=System.currentTimeMillis();

        for(Thread t : threads ) t.start();

        for (Thread t : threads) t.join();

        end=System.currentTimeMillis();

        System.out.println("LongAdder:"+count3.longValue()+" time:"+(end-start));
    }
}
