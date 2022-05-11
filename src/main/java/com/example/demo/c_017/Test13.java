package com.example.demo.c_017;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Test13 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        LockSupport.unpark(thread);
       /* try {
            TimeUnit.SECONDS.sleep(8);
            System.out.println("8 seconds after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);*/
    }
}
