package com.jerry.cn.racecondition;

/**
 * Date: 2017/10/3 10:51
 *
 * @author jerry.R
 */

public class TestMain {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(new Threads()).start();
        }
    }
}
