package com.example.demo.c_017;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test10 {

    private static volatile int value;

    private static ReadWriteLock lock=new ReentrantReadWriteLock();

    //共享锁
    private static Lock readLock=lock.readLock();

    //排他锁，独占锁
    private static Lock writeLock=lock.writeLock();

    //排他锁，独占锁
    static Lock  locks=new ReentrantLock();

    public static void read(Lock lock){
        try{
            lock.lock();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("read value"+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock,int values){
        try{
            lock.lock();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("write value....");
            value=values;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

       // for (int i = 0; i < 18; i++) new Thread(()-> write(writeLock, new Random().nextInt())).start();

        for (int i = 0; i < 18; i++) new Thread(()-> read(readLock)).start();

    }
}
