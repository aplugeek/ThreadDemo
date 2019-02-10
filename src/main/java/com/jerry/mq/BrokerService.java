package com.jerry.mq;

import com.alibaba.rocketmq.shade.io.netty.util.internal.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Date: 2019/2/10 14:01
 *
 * @author jerry.R
 */

public class BrokerService implements Runnable {
    public static final Integer SERVICE_PORT = 9999;
    private final Socket socket;

    public BrokerService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // rewrite back to caller
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            while (true) {
                String message = in.readLine();
                if (StringUtil.isNullOrEmpty(message)) {
                    continue;
                }
                System.out.println("broker Service accept a message:" + message);
                if (message.equals("consume")) {
                    String consumeMessage = Broker.consume();
                    printWriter.println(consumeMessage);
                    printWriter.flush();
                } else {
                    //produce message
                    Broker.produce(message);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVICE_PORT);
        while (true) {
            // every connection offer a thread for service
            // socket.accept() is a blocking method
            BrokerService brokerService = new BrokerService(serverSocket.accept());
            new Thread(brokerService).start();

        }
    }
}
