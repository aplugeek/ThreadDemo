package com.jerry.thread;

/**
 * Date: 17/9/4 14:43
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadTaskConsume threadTaskConsume=new ThreadTaskConsume();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(threadTaskConsume);
            thread.start();
        }

        //To Cancle Thread
        Thread.sleep(100);
        threadTaskConsume.toCancle();
    }


}
