package com.concurrent.impl;

import com.concurrent.CallableTemplate;
import com.concurrent.IConcurrentThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentThreadPool implements IConcurrentThreadPool {
    private ThreadPoolExecutor threadPoolExecutor;

    private int corePoolSize=10;

    private int maximumPoolSize=20;

    private long keepAliveTime=30;

    public void initConcurrentThreadPool() {
      threadPoolExecutor=  new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    }

    public <V> V submit(CallableTemplate<V> task) throws InterruptedException, ExecutionException {
        Future<V> result = threadPoolExecutor.submit(task);
        return result.get();
    }

    public <V> List<V> invokeAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        List<Future<V>> taskResult = threadPoolExecutor.invokeAll(tasks);
        ArrayList<V> resultList = new ArrayList<V>();
        for (Future<V> future:taskResult) {
            resultList.add(future.get());
        }
        return resultList;
    }



}
