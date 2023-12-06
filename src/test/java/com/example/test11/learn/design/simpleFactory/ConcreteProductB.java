package com.example.test11.learn.design.simpleFactory;


public class ConcreteProductB implements Product{

    @Override
    public void use() {
        System.out.println("B  产品正在使用");
    }
}
