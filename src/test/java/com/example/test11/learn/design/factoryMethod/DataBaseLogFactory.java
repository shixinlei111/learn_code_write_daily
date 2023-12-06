package com.example.test11.learn.design.factoryMethod;

public class DataBaseLogFactory implements LogFactory{


    @Override
    public MyLog createLog() {
        
        return new DataBaseLog();
    }
}
