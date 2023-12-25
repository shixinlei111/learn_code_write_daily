package com.example.test11.learn.design.viewer.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class AsyncEventBus extends EventBus{

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
