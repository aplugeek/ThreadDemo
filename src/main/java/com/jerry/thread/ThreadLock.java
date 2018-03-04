package com.jerry.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 17/9/4 16:31
 *
 * @author jerry.R
 */

public class ThreadLock {
    public static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        TaskLocked taskLocked = new TaskLocked();
        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(taskLocked);
            threads[i] = thread;
            thread.start();
        }
        //Use join or CountDownLatch
        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        //Main Thread
        System.out.println(taskLocked.shareData);
    }

}
