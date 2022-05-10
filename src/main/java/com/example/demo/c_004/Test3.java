package com.example.demo.c_004;

public class Test3 {

   static int count=100;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> new Test3().test1()).start();
        }
    }

    //会出现问题,count为类共享 test1锁住的只是当前对象,每次new后都是一个新对象，加锁不影响其他线程执行
    public synchronized void test1(){   //相当于synchronized (this){  }
        count--;
        System.out.println(Thread.currentThread().getName()+"::count::"+count);
    }

    public static synchronized void test2(){  //相当于synchronized (Test3.class){  }
        count--;
        System.out.println(Thread.currentThread().getName()+"::count::"+count);
    }

    public static void test3(){
        synchronized (Test3.class){
            count--;
            System.out.println(Thread.currentThread().getName()+"::count::"+count);
        }
    }
}
