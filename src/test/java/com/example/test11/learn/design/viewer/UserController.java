package com.example.test11.learn.design.viewer;



import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class UserController {

    private UserService userService    ;

     private EventBus eventBus;

    public UserController(EventBus eventBus) {
        this.eventBus = eventBus;
    }





}
