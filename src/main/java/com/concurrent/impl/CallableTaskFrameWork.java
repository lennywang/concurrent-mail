package com.concurrent.impl;

import com.concurrent.CallableTemplate;
import com.concurrent.ICallableTaskFrameWork;
import com.concurrent.IConcurrentThreadPool;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CallableTaskFrameWork implements ICallableTaskFrameWork {
    private IConcurrentThreadPool concurrentThreadPool=  new ConcurrentThreadPool();
    public <V> List<V> submitsAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        concurrentThreadPool.initConcurrentThreadPool();
        return concurrentThreadPool.invokeAll(tasks);
    }
}
