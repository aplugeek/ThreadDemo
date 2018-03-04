package com.jerry.producerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Date: 2018/3/4 13:23
 *
 * @author jerry.R
 */

public class Producer  implements  Runnable {
    private AtomicInteger produceCount = new AtomicInteger();
    private BlockingQueue<Long> blockingQueue ;

    public Producer(BlockingQueue<Long> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        int randomSeed = produceCount.incrementAndGet();
        random.setSeed(randomSeed);
        Long producerData = random.nextLong();
        blockingQueue.add(producerData);
        System.out.println("producer info :  "+producerData);

    }
}
