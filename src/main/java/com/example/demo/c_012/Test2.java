package com.example.demo.c_012;

import java.util.concurrent.TimeUnit;

public class Test2 {

   /*volatile */boolean flag=true;

   //volatile 修饰一个对象只能监测引用指向的对象地址不变，不能监测对象属性值改变
  /* volatile */static Test2 test2=new Test2();

    public void m(){
        System.out.println("m start.....");
        while (flag){
            //sleep操作可以刷新工作内存
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
			/*try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
        }
        System.out.println( "m  end......");
    }


    public static void main(String[] args) {
        new Thread(test2::m).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test2.flag=false;
    }
}
