package com.jerry.pattern;

/**
 * Date: 2019/1/19 12:13
 *
 * @author jerry.R
 */

public class Singleton {
    private Singleton() {

    }

    private static Singleton singleton = null;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

    }
}
