package com.example.demo.c_012;

public class Test3 {

    int a;
    int b;

    public Test3(int a, int b) {
        this.a = a;
        this.b = b;
    }

    volatile static Test3 test;
    public static void main(String[] args) throws InterruptedException {
        Thread write=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                test=new Test3(i,i);
            }

        });


        Thread read= new Thread(()->{
           while (test==null){}

           int x=test.a;
           int y=test.b;

           if(x!=y){
               System.out.println("x:"+x+",y:"+y);
           }
            System.out.println("end.......");
        });


        read.start();
        write.start();


        read.join();
        write.join();


    }
}
