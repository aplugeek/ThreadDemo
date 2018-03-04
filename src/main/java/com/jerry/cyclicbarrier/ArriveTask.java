package com.jerry.cyclicbarrier;

/**
 * Date: 17/9/7 18:36
 *
 * @author jerry.R
 */

public class ArriveTask implements Runnable {
    @Override
    public void run() {
        System.out.println("inside CyclicBarrier...");
    }
}
