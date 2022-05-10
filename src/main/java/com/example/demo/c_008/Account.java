package com.example.demo.c_008;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Account {
     String name;

     double balance;
     public Account(){

     }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


    public synchronized void write(Account account){
        this.name=account.name;

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance=account.balance;

    }

    public double read(){
       return this.balance;
    }


    public static void main(String[] args) throws InterruptedException {
        Account account=new Account();
        new Thread(()-> account.write(new Account("xiaoxiao",100))).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        new Thread(()-> System.out.println(account.read())).start();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> System.out.println(account.read())).start();

    }
}
