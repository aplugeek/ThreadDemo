package com.jerry.mq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Date: 2019/2/10 14:15
 *
 * @author jerry.R
 */

public class MqClient {
    public static void produce(String message) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerService.SERVICE_PORT);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(message);
        printWriter.flush();
    }

    public static String consume() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerService.SERVICE_PORT);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("consume");
        printWriter.flush();
        String message = bufferedReader.readLine();
        System.out.println("consume message content is :" + message);
        return message;

    }
}
