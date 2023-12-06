package com.example.test11.learn.design.viewer.two;

public class SubscriberRegistry2 {


    /**
     * 注册 subscribe 标注的方法
     */
    public void register(Object listener){

        Class<?> aClass = listener.getClass();
        //aClass.getDeclaredAnnotation()

    }
}
