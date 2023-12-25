package com.example.test11.learn.design.template;

public class RealUse1 implements UseMethod1 {
    @Override
    public void run() {
        System.out.println("user1 在跑步");
    }

    @Override
    public void talk() {
        System.out.println("user1 在讲话");
    }
}
