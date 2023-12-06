package com.example.test11.learn.design.simpleFactory;


public class ConcreteProductA implements Product{

    @Override
    public void use() {
        System.out.println("A产品正在使用");
    }
}
