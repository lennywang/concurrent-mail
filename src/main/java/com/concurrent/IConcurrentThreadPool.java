package com.concurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IConcurrentThreadPool {

    void initConcurrentThreadPool();

    <V> V submit(CallableTemplate<V> task) throws InterruptedException, ExecutionException;

    <V> List<V> invokeAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException,ExecutionException;

}
