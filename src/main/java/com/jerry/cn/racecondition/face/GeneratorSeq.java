package com.jerry.cn.racecondition.face;

/**
 * Date: 2017/10/3 10:43
 *
 * @author jerry.R
 */
public interface GeneratorSeq {
    long nextSequence() throws InterruptedException;
}
