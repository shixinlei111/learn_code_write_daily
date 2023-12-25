package com.example.test11.learn.design.template;

public class AbstractClass {


    public static void templateMethod1(UseMethod1 useMethod1){
        System.out.println("原来的一些 固定的东西的 一些开始步骤");
        useMethod1.run();
        useMethod1.talk();
        System.out.println("一些步骤");
    }


    public static void templateMethod2(UseMethod2 useMethod1){
        System.out.println("原来的一些 固定的东西的 一些开始步骤");
        useMethod1.song();
        useMethod1.surfnet();
        System.out.println("一些步骤");
    }
}
