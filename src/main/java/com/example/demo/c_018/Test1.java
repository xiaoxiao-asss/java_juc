package com.example.demo.c_018;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Test1 {

    List list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                test1.add(i);
                System.out.println("add"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (test1.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 end....");
        }).start();
    }
}
