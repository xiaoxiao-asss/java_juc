package com.example.demo.c_017;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test5 extends Thread {

    private static Lock lock=new ReentrantLock(true);  //参数为true表示为公平锁，请对比输出结果

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
           try{
               lock.lock();
               System.out.println(Thread.currentThread().getName()+"获得锁"+i);
           }finally {
               lock.unlock();
           }
            
        }
    }

    public static void main(String[] args) {
        new Test5().start();
        new Test5().start();
    }
}
