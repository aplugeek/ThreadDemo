package com.jerry.cn.SqlMultiThread;

/**
 * Date: 2017/10/10 21:48
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) {
        SqlChecker sqlChecker = new SqlChecker();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new InsertThread(sqlChecker));
            thread.start();
        }

    }
}
