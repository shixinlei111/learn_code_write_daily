package com.example.test11.learn.design.Bridge;


public class WindowPlatform extends Platform {


    @Override
    void viewVideo(VideoFormat videoFormat) {
        System.out.println("this is  windows");
        videoFormat.playVideo();
    }
}
