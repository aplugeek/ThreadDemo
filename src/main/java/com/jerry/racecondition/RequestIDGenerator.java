package com.jerry.racecondition;

import com.jerry.cn.racecondition.face.GeneratorSeq;
import com.jerry.racecondition.face.GeneratorSeq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Date: 2017/10/3 10:40
 *
 * @author jerry.R
 */

public class RequestIDGenerator implements GeneratorSeq {
    public static final RequestIDGenerator INSTANCE = new RequestIDGenerator();
    private static short SEQ_LIMIT = 999;
    //private static short ID;
    private final AtomicLong ID = new AtomicLong(0L);

    private RequestIDGenerator() {
    }

    @Override
    public long nextSequence() throws InterruptedException {
        Thread.sleep(5000);

        return ID.incrementAndGet();
    }

    public void getSeq() throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmSS");
        String timeStamp = simpleDateFormat.format(new Date());
        System.out.println(timeStamp+"--"+nextSequence());

    }

    public static RequestIDGenerator getInstance() {
        return INSTANCE;
    }
}
