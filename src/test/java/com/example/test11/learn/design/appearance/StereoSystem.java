package com.example.test11.learn.design.appearance;


//外观角色
public class StereoSystem {

    private CdPlayer cdPlayer;
    private Amplifier amplifier;
    private Lights lights;


    public StereoSystem() {
        this.cdPlayer = new CdPlayer();
        this.amplifier = new Amplifier();
        this.lights = new Lights();
    }


    public void startMusic(){

        cdPlayer.play();
        amplifier.on();
        amplifier.setVolume(5);
        lights.dim();

    }

    public void endMusic(){
        cdPlayer.stop();
        amplifier.close();
        lights.bright();
    }
}
