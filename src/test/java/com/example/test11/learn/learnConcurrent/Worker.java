package com.example.test11.learn.learnConcurrent;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{


    private  final   CountDownLatch startSignal;

    private  final   CountDownLatch doneSignal;


    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {

        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("线程:"+name+"执行完了");
        doneSignal.countDown();
    }
}
