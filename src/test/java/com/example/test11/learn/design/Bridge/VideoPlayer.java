package com.example.test11.learn.design.Bridge;

/**
 * 桥接器
 */
public class VideoPlayer {

    private Platform platform;

    public void playVideo(VideoFormat videoFormat){
        platform.viewVideo(videoFormat);
    }

    public VideoPlayer(Platform platform) {
        this.platform = platform;
    }
}
