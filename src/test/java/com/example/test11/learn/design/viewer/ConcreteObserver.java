package com.example.test11.learn.design.viewer;

public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String subjectState) {

        System.out.println(name+"接收到 了 状态变更，新状态为："+subjectState);

    }
}
