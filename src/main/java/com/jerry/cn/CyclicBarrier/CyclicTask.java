package com.jerry.cn.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Date: 17/9/7 18:26
 *
 * @author jerry.R
 */

public class CyclicTask implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CyclicTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "is wating...");
            doTask();
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + "is doing");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }


    private void doTask() throws InterruptedException {
        Thread.sleep(1000);
    }
}
