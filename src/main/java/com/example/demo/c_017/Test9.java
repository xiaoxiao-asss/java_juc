package com.example.demo.c_017;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Phaser
 */
public class Test9 {
    static Random r = new Random();
    static TestPhaser phaser = new TestPhaser();


    static void milliSleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        phaser.bulkRegister(7);

        for (int i = 0; i < 5; i++) {
            new Thread(new Person("name:"+i)).start();
        }

        new Thread(new Person("test1")).start();
        new Thread(new Person("test2")).start();
    }

    static class TestPhaser extends Phaser {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {

            switch (phase) {
                case 0:
                    System.out.println("都到了"+registeredParties);
                    return false;
                case 1:
                    System.out.println("都吃完了"+registeredParties);
                    return false;
                case 2:
                    System.out.println("都离开了"+registeredParties);
                    return false;
                case 3:
                    System.out.println("结束"+registeredParties);
                    return true;
                default:
                    return true;

            }
        }
    }

    static class Person extends Thread {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            test();
        }

        public void arrive() {
            milliSleep(r.nextInt(1000));
            System.out.println(name + "到达");
            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            milliSleep(r.nextInt(1000));
            System.out.println(name + "吃");
            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            milliSleep(r.nextInt(1000));
            System.out.println(name + "离开");
            phaser.arriveAndAwaitAdvance();
        }

        public void test(){
            if("test1".equals(name)||"test2".equals(name)){
                System.out.println(name + "离开");
                phaser.arriveAndAwaitAdvance();
            }else{
                phaser.arriveAndDeregister();
            }
        }

    }
}



