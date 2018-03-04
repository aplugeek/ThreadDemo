package com.jerry.producerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Date: 2018/3/4 13:34
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Long> blockingQueue = new LinkedBlockingDeque<>();
        Producer producer1 = new Producer(blockingQueue);
        Producer producer2 = new Producer(blockingQueue);
        Consumer consumer1 = new Consumer(blockingQueue);
        Consumer consumer2 = new Consumer(blockingQueue);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(consumer1);
        service.execute(consumer2);
    }
}
