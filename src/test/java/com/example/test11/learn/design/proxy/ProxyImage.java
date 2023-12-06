package com.example.test11.learn.design.proxy;

public class ProxyImage implements Image {

    private RealImage realImage;

    private String imageName;

    public ProxyImage(String imageName) {
        this.imageName = imageName;
        this.realImage = new RealImage(imageName);
    }

    @Override
    public void display() {
        beforeDisplay();
        realImage.display();
        afterDisplay();
    }

    void beforeDisplay(){
        System.out.println("检测到 输入的图片名为："+ imageName);
    }

    void afterDisplay(){
        System.out.println("展示图片结束");
    }
}
