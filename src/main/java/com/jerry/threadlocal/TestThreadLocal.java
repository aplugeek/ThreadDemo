package com.jerry.threadlocal;

/**
 * Date: 17/9/18 09:40
 *
 * @author jerry.R
 */

public class TestThreadLocal {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // get Connection by function  getConnection(ThreadLocal)
        Connection connection = getConnection(1);
        connection.getConnInfo();
    }

    public static Connection getConnection(int index) {
        if (threadLocal.get() == null) {
            Connection connection = new Connection(index);
            threadLocal.set(connection);
            return connection;
        }
        return threadLocal.get();
    }
}
