package com.jerry.cn.SqlMultiThread;

/**
 * Date: 2017/10/10 21:47
 *
 * @author jerry.R
 */

public class InsertThread implements Runnable {
    private SqlChecker sqlChecker;
    public InsertThread( SqlChecker sqlChecker) {
        this.sqlChecker = sqlChecker;
    }

    @Override
    public void run() {
        sqlChecker.checkAndInsert();
    }
}
