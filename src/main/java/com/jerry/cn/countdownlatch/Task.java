package com.jerry.cn.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Date: 17/9/7 16:53
 *
 * @author jerry.R
 */

public class Task implements Runnable {
    private CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();

    }

    private void doWork() {
        System.out.println("task" + Thread.currentThread().getName() + "completed");
    }
}
