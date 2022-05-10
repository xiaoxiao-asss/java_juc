package com.example.demo.c_017;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        Test4 test = new Test4();
        ReentrantLock lock = new ReentrantLock();
        Thread thread1=new Thread(()->{
            try {
                lock.lock();
                System.out.println("m start...");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("m end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        thread1.start();



        Thread thread2=new Thread(()->{
            try {
                lock.lockInterruptibly();   //可以对interrupt()方法做出响应
                System.out.println("n start...");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("n end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        thread2.start();

        TimeUnit.SECONDS.sleep(1);

        thread2.interrupt();


    }
}
