package com.example.test11.learn.design.command;

public class LightOnCommand implements Command {


    private LIght lIght;

    public LightOnCommand(LIght lIght) {
        this.lIght = lIght;
    }

    @Override
    public void execute() {
        lIght.turnOn();
    }
}
