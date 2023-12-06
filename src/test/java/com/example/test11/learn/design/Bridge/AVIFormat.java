package com.example.test11.learn.design.Bridge;

public class AVIFormat extends VideoFormat {

    @Override
    void playVideo() {
        System.out.println("播放 avi 视频");
    }

}
