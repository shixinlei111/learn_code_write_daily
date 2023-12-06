package com.example.test11.learn.design.abstractFactoryMethod;

public class YadiFactory implements AbstractFactory {
    @Override
    public ElectricCar createProductA() {
        return new ElectricCarOfYadi();
    }

    @Override
    public Cake createProductB() {
        return new CakeOfYaDi();
    }
}
