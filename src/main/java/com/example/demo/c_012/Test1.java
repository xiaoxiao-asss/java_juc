package com.example.demo.c_012;

import com.example.demo.c_009.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {

    //volatile 保证线程间的可见性
   /*volatile*/  boolean flag=true;

    public void m(){
        System.out.println("start.....");
        while (flag){
            //println中有synchronized会刷新县城工作内存变量的值
            //System.out.println("..................");
        }
        System.out.println("end.....");
    }


    public  static void main(String[] args) {
        Test1 test=new Test1();
        new Thread(test::m).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.flag=false;
    }





}
