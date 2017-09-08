package com.jerry.cn.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Date: 17/9/7 18:26
 *
 * @author jerry.R
 */

public class CyclicMain {
    public static void main(String[] args) {
        Thread arriveTask = new Thread(new ArriveTask());
        //define cyclic task
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, arriveTask);
        CyclicTask cyclicTask = new CyclicTask(cyclicBarrier);
        for (int i = 0; i < 10; i++) {
            new Thread(cyclicTask).start();
        }

    }
}
