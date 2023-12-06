package com.example.test11.learn.design.command;

public class RemoteControl {


    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() throws InterruptedException {
        command.execute();
    }
}
