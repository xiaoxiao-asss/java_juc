package com.example.demo.c_010;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.TimeUnit;

public class T {

    public synchronized void m(){
        System.out.println(this);
        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("super m");
    }

    public static void main(String[] args) {
        TT tt=new TT();
        new Thread(tt::m).start();
    }

}

class TT extends T {

    @Override
    public synchronized void m() {
        System.out.println(this);
        System.out.println(super.toString());
        System.out.println("child m start....");
        super.m();
        System.out.println("child m end.....");
    }
}
