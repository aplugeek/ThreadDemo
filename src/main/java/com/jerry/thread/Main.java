package com.jerry.thread;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Date: 17/9/4 14:43
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) throws InterruptedException, ScriptException {
//        ThreadTaskConsume threadTaskConsume=new ThreadTaskConsume();
//        for (int i = 0; i < 100; i++) {
//            Thread thread = new Thread(threadTaskConsume);
//            thread.start();
//        }
//
//        //To Cancle Thread
//        Thread.sleep(100);
//        threadTaskConsume.toCancle();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        System.out.println(engine.eval("10+2"));
    }


}
