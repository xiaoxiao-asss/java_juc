package com.example.demo.c_005;

public class Test1 implements Runnable {

    /**
     * volatile 不可保证原子性
     */
    private /*volatile*/ int count=100;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+",count:"+count);
    }

    public static void main(String[] args) {
        Test1 test=new Test1();
       /* Thread[]threads=new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i]=new Thread(test,"thread"+i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
*/

        for (int i = 0; i < 100; i++) {
           new Thread(test,"thread"+i).start();
        }

    }


}

