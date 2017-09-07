package com.jerry.cn.CyclicBarrier;

/**
 * Date: 17/9/7 18:26
 *
 * @author jerry.R
 */

public class CyclicBarrier {
    public static void main(String[] args) {
        Thread arriveTask = new Thread(new ArriveTask());
        java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(10, new Runnable() {
            //当所有线程到达barrier时执行
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("Inside Barrier");
            }
        });
        CyclicTask cyclicTask = new CyclicTask(cyclicBarrier);
        for (int i = 0; i < 10; i++) {
            new Thread(cyclicTask).start();
        }

    }
}
