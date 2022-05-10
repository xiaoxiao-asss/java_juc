package com.example.demo.c_017;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
    ReentrantLock lock = new ReentrantLock();

    void m() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        } finally {
            lock.unlock();
        }


    }

    void n() {
        boolean locked = false;

        try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2 ..." + locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(locked) lock.unlock();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Test3 test = new Test3();
        new Thread(test::m).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(test::n).start();
    }
}
