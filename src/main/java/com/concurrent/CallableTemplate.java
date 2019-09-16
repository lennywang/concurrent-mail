package com.concurrent;

import java.util.concurrent.Callable;

public abstract class CallableTemplate<V> implements Callable<V> {

    public void beforeProcess(){
        System.out.println("before process...");
    }

    public abstract V process();

    public void afterProcess(){
        System.out.println("after process...");
    }

    public V call(){
        beforeProcess();
        V result = process();
        afterProcess();
        return result;
    }

}
