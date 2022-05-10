package com.example.demo.c_013;

import com.example.demo.c_012.Test4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    int count = 0;

    public synchronized void m() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;

        System.out.println(Thread.currentThread().getName()+":count:"+count);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void n() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            count++;
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        Test test4 = new Test();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(test4::m, "thread" + i));
        }

        list.forEach(item -> {
            item.start();
        });


        list.forEach(item -> {
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(test4.count);


    }
}
