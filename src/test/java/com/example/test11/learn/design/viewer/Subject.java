package com.example.test11.learn.design.viewer;

public interface Subject {

    void addObserver(Observer  observer);
    void removeObsever(Observer observer);
    void notifyServer();
}
