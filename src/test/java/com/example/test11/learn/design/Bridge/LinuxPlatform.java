package com.example.test11.learn.design.Bridge;

public class LinuxPlatform extends Platform {


    @Override
    void viewVideo(VideoFormat videoFormat) {
        System.out.println("this is linux  平台");
        videoFormat.playVideo();
    }
}
