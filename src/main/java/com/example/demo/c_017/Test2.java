package com.example.demo.c_017;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    ReentrantLock lock = new ReentrantLock();

    void m() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                if (i == 2) {
                    n();
                }

            }
        } catch (Exception e) {
            lock.unlock();
        }


    }

    void n() {
        try {
            lock.lock();
            System.out.println("n.....");
        } catch (Exception e) {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        new Thread(test::m).start();
    }
}
