package com.example.demo.c_015;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    AtomicInteger integer=new AtomicInteger(0);

    public void m(){
        for (int i = 0; i < 100; i++) {
            integer.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Test test=new Test();
        List<Thread> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(test::m,"thread"+i));
        }

        list.forEach(item->item.start());

        list.forEach(item-> {
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(test.integer);
    }
}
