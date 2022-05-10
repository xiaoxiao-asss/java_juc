package com.example.demo.c_016;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射获取Unsafe，默认非系统类不能直接调用Unsafe
 */
public class HelloUnsafe {

    class Test{

        private Test(){}

        private int m;

        @Override
        public String toString() {
            return "m:"+m;
        }
    }


    public static void main(String[] args) throws InstantiationException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {


        //不能直接操作Unsafe，会出现Exception in thread "main" java.lang.SecurityException: Unsafe
       /* Unsafe unsafe=Unsafe.getUnsafe();
        Test test=(Test)unsafe.allocateInstance(Test.class);
        test.m=1;
        System.out.println(test.m);*/

        Class classes=Unsafe.class;
        Field field=classes.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe=(Unsafe)field.get(null);
        Test test=(Test)unsafe.allocateInstance(Test.class);
        test.m=1;
        System.out.println(test.m);







    }
}
