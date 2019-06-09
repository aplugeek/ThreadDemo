package com.jerry.threadlocal;

/**
 * Date: 2019-05-03 17:51
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Integer index = i;
            new Thread(() -> {
                TestThreadLocal.getConnection(index).getConnInfo();
            }).start();

        }
    }
}
