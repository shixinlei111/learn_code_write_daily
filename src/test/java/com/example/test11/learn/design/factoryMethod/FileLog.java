package com.example.test11.learn.design.factoryMethod;

import lombok.Data;

@Data
public class FileLog extends MyLog{


    @Override
    void writeLog() {
        // 文件  写数据
        System.out.println("文件写数据");
    }
}
