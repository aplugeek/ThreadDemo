package com.jerry.racecondition;

/**
 * Date: 2017/10/3 10:53
 *
 * @author jerry.R
 */

public class Threads implements Runnable {
    RequestIDGenerator requestIDGenerator = RequestIDGenerator.getInstance();

    @Override
    public void run() {

        try {
            sleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep() throws InterruptedException {
        //System.out.println(Thread.currentThread().getName() + "---" + requestIDGenerator.getSeq());
        requestIDGenerator.getSeq();
    }

}
