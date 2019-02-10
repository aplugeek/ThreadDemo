package com.jerry.mq;

import java.io.IOException;

/**
 * Date: 2019/2/10 14:25
 *
 * @author jerry.R
 */

public class Producer {
    public static void main(String[] args) throws IOException {
        MqClient.produce("this is a mq message...");
    }
}
