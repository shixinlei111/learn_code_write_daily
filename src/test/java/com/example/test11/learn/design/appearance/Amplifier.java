package com.example.test11.learn.design.appearance;


//子系统中的组件
public class Amplifier {

    void on() {
        System.out.println("Amplifier is on");
    }


    void setVolume(int volume) {
        System.out.println("Volume 设置为："+volume);
    }


    void close() {
        System.out.println("Amplifier is close");
    }

}
