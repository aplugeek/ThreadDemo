package com.jerry.cn.redisqueue;

import com.jerry.cn.redisqueue.ConsumerTask.ConsumerTask;

/**
 * Date: 17/9/18 12:44
 *
 * @author jerry.R
 */

public class RedisConsumer {
    public static void main(String[] args) {
        Thread thread = new Thread(new ConsumerTask());
        thread.start();
        System.out.println("queue Thread is listening..");
    }
}
