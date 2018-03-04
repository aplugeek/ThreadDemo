package com.jerry.thread;

/**
 * Date: 17/9/4 14:39
 *
 * @author jerry.R
 */

public class ThreadTaskConsume implements Runnable {
//    private volatile boolean toCancle = false;
    private  boolean toCancle = false;

    public void run() {
        while (!toCancle) {
            if (doExcute()) {
                break;
            }
        }
    }

    private boolean doExcute() {
        System.out.println("Thread is startinng ---" + Thread.currentThread().getName());

        return false;
    }

    public void toCancle() {
        this.toCancle = true;
    }
}
