package com.example.test11.learn.design.adapter;

public class AdapterMy implements Target{

    private Adaptee adaptee;

    public AdapterMy(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
