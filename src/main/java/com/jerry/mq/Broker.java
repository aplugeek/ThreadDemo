package com.jerry.mq;

import com.alibaba.rocketmq.shade.io.netty.util.internal.StringUtil;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Date: 2019/2/10 13:38
 *
 * @author jerry.R
 */

public class Broker {
    private static final Integer MAX_SIZE = 10;
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    public static void produce(String message) {
        if (StringUtil.isNullOrEmpty(message)) {
            return;
        }
        if (messageQueue.offer((message))) {
            System.out.println("success offer message to broker...message content:" + message);
        } else {
            System.err.println("faild to emit message to broker... message content:" + message);
        }
    }

    public static String consume() {
        String message = messageQueue.poll();
        if (!StringUtil.isNullOrEmpty(message)) {
            System.out.println("conusme a message of queue,message content is:" + message);
            return message;
        } else {
            System.err.println("consume failed, queue is empty or message content is empty..");
        }
        return message;
    }
}
