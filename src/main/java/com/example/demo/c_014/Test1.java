package com.example.demo.c_014;

import java.util.concurrent.TimeUnit;

/**
 * 不要使用synchronized维护一个字符串常量，内容相同，常量池中只创建一次，，不同的引用都会指向同一个常量池地址
 */
public class Test1 {


    public static void main(String[] args) {
        String str1="tst";
        String str2="tst";

        new Thread(()->{
            synchronized (str1){
                System.out.println("111111");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            synchronized (str2){
                System.out.println("222222");
            }
        }).start();
    }

}
