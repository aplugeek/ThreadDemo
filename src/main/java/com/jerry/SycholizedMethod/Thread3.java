package com.jerry.SycholizedMethod;

/**
 * Date: 17/9/21 15:06
 *
 * @author jerry.R
 */

public class Thread3 implements  Runnable {
    private  SycholizedMethod sycholizedMethod;

    public Thread3(SycholizedMethod sycholizedMethod) {
        this.sycholizedMethod = sycholizedMethod;
    }

    @Override
    public void run() {
        try {
            sycholizedMethod.test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
