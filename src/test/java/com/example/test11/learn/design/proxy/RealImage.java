package com.example.test11.learn.design.proxy;

public class RealImage implements Image {

    String imageName;

    public RealImage(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void display() {
        System.out.println("正在展示该图片："+ imageName);
    }
}
