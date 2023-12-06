package com.example.test11.learn.design.factoryMethod;

import lombok.Data;

@Data
public class DataBaseLog extends MyLog{


    @Override
    void writeLog() {
      //数据库  写数据
        System.out.println("数据库写数据");
    }
}
