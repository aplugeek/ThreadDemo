package com.jerry.scheduler;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2018/8/18 23:42
 *
 * @author jerry.R
 */

public class Executor {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(4);
//        service.execute(()-> System.out.println("executor......."));
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(20);
//        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("12"), 1, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println( sf.format(System.currentTimeMillis()));
                Thread.sleep((long) (Math.random() * 1000000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("end 1");
        }, 1, 10, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            try {
//                System.out.println("start 1");
//                Thread.sleep(20000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("end 1");
//        }, 1, 1, TimeUnit.SECONDS);
    }
}

