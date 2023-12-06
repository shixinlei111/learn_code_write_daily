package com.example.test11.learn.design.command;

public class LightOffCommand implements Command {


    private LIght lIght;

    public LightOffCommand(LIght lIght) {
        this.lIght = lIght;
    }

    @Override
    public void execute() {
        lIght.turnOff();
    }
}
