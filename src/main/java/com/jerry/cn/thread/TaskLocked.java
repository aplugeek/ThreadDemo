package com.jerry.cn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 17/9/4 16:32
 *
 * @author jerry.R
 */

public class TaskLocked implements Runnable {
    Lock lock = new ReentrantLock(true);

    int shareData = 0;

    public void run() {
        lock.lock();
        try {
            Thread.sleep(1000);
            shareData++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
