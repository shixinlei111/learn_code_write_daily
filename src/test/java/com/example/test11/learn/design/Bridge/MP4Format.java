package com.example.test11.learn.design.Bridge;

public class MP4Format extends VideoFormat {


    @Override
    void playVideo() {
        System.out.println("播放 mp4 视频");
    }
}
