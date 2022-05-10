package com.example.demo.c_011;

import java.util.concurrent.TimeUnit;

public class Test {

    int count=0;

    public void m(){

      synchronized (this){
          while (true){
              count++;
              System.out.println(Thread.currentThread().getName()+":count:"+count);

              try {
                  TimeUnit.SECONDS.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

              if(count==5){
                  int a= count/0;  //此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch，然后让循环继续b
                  System.out.println(a);
              }
          }
      }

    }

    public static void main(String[] args) {
        Test test=new Test();

        new Thread(test::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(test::m,"t2").start();
    }
}
