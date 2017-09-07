package com.jerry.cn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 17/9/4 16:46
 *
 * @author jerry.R
 */

public class ThreadDump {
    private static final Lock lock = new ReentrantLock();
    private static int shareData = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    try {
                        System.out.println("thread is executing...");
                        Thread.dumpStack();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    shareData = 1;
                } finally {
                    lock.unlock();
                }

            }
        });

        t.start();
        Thread.sleep(100);
        Thread.dumpStack();
        lock.lock();
        try {
            System.out.println("shareData:" + shareData);
        } finally {
            lock.unlock();
        }
    }
}
