package com.example.test11.learn.design.factoryMethod;

public class FileLogFactory implements LogFactory{


    @Override
    public MyLog createLog() {

        return new FileLog();
    }
}
