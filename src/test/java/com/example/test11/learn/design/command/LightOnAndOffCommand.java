package com.example.test11.learn.design.command;


import lombok.Data;

@Data
public class LightOnAndOffCommand implements Command {

    //按道理直接 注入，如果用spring 的话
    private LightOnCommand lightOnCommand;
    private LightOffCommand lightOffCommand;



    @Override
    public void execute() throws InterruptedException {
        lightOnCommand.execute();
        System.out.println("定时 3秒关机");
        Thread.sleep(3000);
        lightOffCommand.execute();
    }
}
