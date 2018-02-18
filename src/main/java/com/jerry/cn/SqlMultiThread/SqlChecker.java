package com.jerry.cn.SqlMultiThread;

/**
 * Date: 2017/10/10 21:50
 *
 * @author jerry.R
 */

public class SqlChecker {

    public SqlChecker() {
    }

    public volatile boolean flag = true;

    public synchronized boolean getFlag() {
        boolean tmp = flag;
        if (flag) {
            setFlag();
        }
        return tmp;
    }

    public void setFlag() {
        flag = false;
    }

    public void checkAndInsert() {
        if (getFlag()) {
            System.out.println("insert sql .....");
        } else {
            System.out.println("conditions not allowed...");
        }
    }


}
