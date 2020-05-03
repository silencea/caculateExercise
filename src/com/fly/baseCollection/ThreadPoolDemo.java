package com.fly.baseCollection;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA
 * Created By lifeifei
 * Date: 2020/5/3
 * Time: 9:21
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue1 = new PriorityBlockingQueue<>();
        BlockingQueue<String> blockingQueue2 = new LinkedBlockingQueue<>();
        BlockingQueue<String> blockingQueue3 = new ArrayBlockingQueue(0);
        BlockingQueue<String> blockingQueue4 = new DelayQueue();
        BlockingQueue<String> blockingQueue5 = new SynchronousQueue<>();
        BlockingQueue<String> blockingQueue6 = new LinkedBlockingDeque<>();


        Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(1);
    }
}
