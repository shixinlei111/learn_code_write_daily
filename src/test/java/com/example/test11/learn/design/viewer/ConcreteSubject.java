package com.example.test11.learn.design.viewer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {


    private List<Observer> observers = new ArrayList<>();

    private String state;


    public void setState(String state) {
        this.state = state;
        notifyServer();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObsever(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyServer() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
