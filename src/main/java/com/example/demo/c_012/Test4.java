package com.example.demo.c_012;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

    //volatile不能保证线程安全
   /*volatile */int count=0;

    public synchronized   void m(){
        for (int i = 0; i < 1000; i++) {
            count++;
        }

    }



    public static void main(String[] args) {

       List<Thread> list =new ArrayList<>();
        Test4 test4=new Test4();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(test4::m,"thread"+i));
        }

        list.forEach(item->{
            item.start();
        });


        list.forEach(item->{
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



        System.out.println(test4.count);

    }
}
