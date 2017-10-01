package com.jerry.cn.paramlock;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 * Date: 2017/10/1 09:33
 *
 * @author jerry.R
 */

public class LogPrinter {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmm");
    private PrintWriter printWriter = null;


    public void print() throws FileNotFoundException {
        synchronized (this) {
            printWriter = getPrintWriter();
        }

    }

    public synchronized void shutdown() {
        if (null != printWriter) {
            printWriter.close();
            printWriter = null;
        }

    }

    private PrintWriter getPrintWriter() throws FileNotFoundException {
        String filename = "/test/test/txt";
        printWriter = new PrintWriter(filename) {
            {
                lock = this;

            }//instance init block
        };
        return printWriter;
    }
}
