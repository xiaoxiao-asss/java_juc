package com.example.demo.c_017;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 必须达到设置的线程数，才会执行后面的命令
 * 注意：在一个线程中循环调用指定次数的await()无效，必须由多个线程分别调用await()
 */
public class Test7  {


    public static void main(String[] args) {
        CyclicBarrier cb=new CyclicBarrier(10, ()->System.out.println("测试"));

        for (int i = 0; i < 121; i++) {
            new Thread(()->{
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
