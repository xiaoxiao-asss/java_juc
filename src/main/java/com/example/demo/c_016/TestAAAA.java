package com.example.demo.c_016;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestAAAA {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //不能直接操作Unsafe，会出现Exception in thread "main" java.lang.SecurityException: Unsafe
       /* Unsafe unsafe=Unsafe.getUnsafe();
        Test test=(Test)unsafe.allocateInstance(Test.class);
        test.m=1;
        System.out.println(test.m);*/

        /*Class classes=Unsafe.class;
        Field field=classes.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe=(Unsafe)field.get(null);*/



        //构造方法为私有时
        Constructor<AAAA> constructor= AAAA.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        AAAA a=constructor.newInstance();

        /**
         * 构造方法非私有
         */
        //AAAA a=AAAA.class.newInstance();

        Field field=AAAA.class.getDeclaredField("a");
        field.setAccessible(true);
        //通过字段获取对象，字段不是静态字段的话,要传入反射类的对象.如果传null是会报空指针异常
        System.out.println(field.get(a));
        Field field2=AAAA.class.getDeclaredField("b");
        field2.setAccessible(true);
        //通过属性获取该属性对应的具体对象，传null是因为属性b为静态属性
        System.out.println(field2.get(null));


    }
}

