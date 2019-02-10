package com.jerry.mq;

import java.io.IOException;

/**
 * Date: 2019/2/10 14:28
 *
 * @author jerry.R
 */

public class Consumer {
    public static void main(String[] args) throws IOException {
        String message = MqClient.consume();
        System.out.println(message);
    }
}
