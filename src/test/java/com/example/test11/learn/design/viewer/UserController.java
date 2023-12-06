package com.example.test11.learn.design.viewer;



import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class UserController {

    private UserService userService    ;
    private static  final  int event_bus_size = 20;

    private EventBus eventBus;

    public UserController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(event_bus_size));
    }


    public void setRegObservers(List<Object> observers){
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    
    public Long register(String telephone,String  password){
        long userId = 1;
        eventBus.post(userId);
        return userId;
    }
}
