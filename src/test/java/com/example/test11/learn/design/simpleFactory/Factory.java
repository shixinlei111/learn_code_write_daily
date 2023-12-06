package com.example.test11.learn.design.simpleFactory;


public class Factory {

    public static Product createProduct(String name){

        if ("A".equals(name)){
            return new ConcreteProductA();
        }

        if ("B".equals(name)){
            return new ConcreteProductB();
        }

        return null;
    }


}
