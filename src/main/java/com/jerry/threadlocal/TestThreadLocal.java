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
        Connection connection = getConnection();
        connection.getConnInfo();
    }

    private static Connection getConnection() {
        if (threadLocal.get() == null) {
            Connection connection = new Connection();
            threadLocal.set(connection);
            return connection;
        }
        return threadLocal.get();
    }
}
