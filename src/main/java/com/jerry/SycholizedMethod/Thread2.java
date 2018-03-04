package com.jerry.SycholizedMethod;

/**
 * Date: 17/9/21 14:52
 *
 * @author jerry.R
 */

public class Thread2 implements  Runnable {
    private SycholizedMethod sycholizedMethod;

    public Thread2(SycholizedMethod sycholizedMethod) {
        this.sycholizedMethod = sycholizedMethod;
    }
    @Override
    public void run() {
        try {
            sycholizedMethod.test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
