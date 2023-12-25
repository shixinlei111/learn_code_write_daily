package com.example.test11.learn.design.viewer.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class EventBus {

    private Executor executor;

    private MyObserverRegistry registry = new MyObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor){
        executor = this.executor;
    }


    public void register(Object object){
        registry.register(object);
    }


    public void post(Object event){
        List<ObserverAction> matchedObserverActions = registry.getMatchedObserverActions(event);
        for (ObserverAction matchedObserverAction : matchedObserverActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    matchedObserverAction.execute(event);
                }
            });
        }
    }
}
