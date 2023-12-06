package com.example.test11.learn.design.abstractFactoryMethod;

public class BYDFactory implements AbstractFactory {
    @Override
    public ElectricCar createProductA() {
        return new ElectricCarOfBYD();
    }

    @Override
    public Cake createProductB() {
        return new CakeBYD();
    }
}
