package com.jerry.producerAndConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Date: 2018/3/4 13:31
 *
 * @author jerry.R
 */

public class Consumer implements Runnable {
    private BlockingQueue<Long> blockingQueue;

    public Consumer(BlockingQueue<Long> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Long consumerData = blockingQueue.take();
            if(consumerData!= null){
                System.out.println("consumer data from producer : " + consumerData);
            }else {
                System.out.println("no producer data get ...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
