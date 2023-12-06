package com.example.test11.learn.design.viewer;

import com.google.common.eventbus.Subscribe;

public class RegNotificationObserver   {

    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
        //notificationService.sendInboxMessage(userId,"Welcome to...");
        System.out.println("welcome to ,userid 为"+userId);
    }
}
