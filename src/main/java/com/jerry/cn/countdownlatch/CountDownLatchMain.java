package com.jerry.cn.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Date: 17/9/7 16:56
 *
 * @author jerry.R
 */

public class CountDownLatchMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(new Task(countDownLatch));
        Thread thread2 = new Thread(new Task(countDownLatch));

        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println("all thread is completed");
    }
}
