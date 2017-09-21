package com.jerry.cn.SycholizedMethod;

/**
 * Date: 17/9/21 15:07
 *
 * @author jerry.R
 */

public class Thread4 implements Runnable {
    private  SycholizedMethod sycholizedMethod;

    public Thread4(SycholizedMethod sycholizedMethod) {
        this.sycholizedMethod = sycholizedMethod;
    }

    @Override
    public void run() {
        try {
            sycholizedMethod.test4();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
