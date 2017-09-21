package com.jerry.cn.SycholizedMethod;

/**
 * Date: 17/9/21 14:52
 *
 * @author jerry.R
 */

public class Thread1 implements Runnable {
    private SycholizedMethod sycholizedMethod;

    public Thread1(SycholizedMethod sycholizedMethod) {
        this.sycholizedMethod = sycholizedMethod;
    }

    @Override
    public void run() {
        try {
            sycholizedMethod.test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
