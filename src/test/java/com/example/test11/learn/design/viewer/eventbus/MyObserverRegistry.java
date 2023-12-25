package com.example.test11.learn.design.viewer.eventbus;

import com.google.common.base.MoreObjects;
import org.assertj.core.util.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class MyObserverRegistry {


    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry =
            new ConcurrentHashMap<>();

    public void register(Object observer){
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            //有没有加过这种参数类型的，或者 是父子类型关系的，
            CopyOnWriteArraySet<ObserverAction> registedEventActions = registry.get(eventType);
            if (registedEventActions == null){
                CopyOnWriteArraySet<ObserverAction> valueWill = new CopyOnWriteArraySet<>();
                //多线程竞争，putIfAbsent 原子操作
                registedEventActions = MoreObjects.firstNonNull(registry.putIfAbsent(eventType,valueWill),valueWill);
            }
            registedEventActions.addAll(eventActions);
        }
    }


    public List<ObserverAction> getMatchedObserverActions(Object event){
        ArrayList<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            if (eventType.isAssignableFrom(postedEventType)){
                matchedObservers.addAll(entry.getValue());
            }
        }
        return matchedObservers;
    }


    // 找  被subscribe 标注的 方法，可能有参数类型相同的，或者是父子类型的方法
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {

        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> aClass = observer.getClass();
        List<Method> methods = getAnnotatedMethods(aClass);

        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> parameterType = parameterTypes[0];
            if (!observerActions.containsKey(parameterType)){
                observerActions.put(parameterType,new ArrayList<>());
            }
            observerActions.get(parameterType).add(new ObserverAction(observer,method));
        }
        return  observerActions;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Preconditions.checkArgument(parameterTypes.length == 1,
                    "Method %s has @Subscribe annotation but has %s parameters" +
                            "SubscriberMethods must have exactly 1 parameters"
                     ,method,parameterTypes.length
                    );
            annotatedMethods.add(method);
        }

        return annotatedMethods;
    }
}
