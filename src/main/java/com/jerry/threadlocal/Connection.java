package com.jerry.threadlocal;

/**
 * Date: 17/9/18 09:41
 *
 * @author jerry.R
 */

public class Connection {
    private int index;

    public Connection(int index) {
        this.index = index;
    }

    //simplely use sout replace
    public void getConnInfo() {
        System.out.println("get Connection...index:" + index);
    }

}
