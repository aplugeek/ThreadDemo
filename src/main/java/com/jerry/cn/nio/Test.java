package com.jerry.cn.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date: 2018/2/9 23:19
 *
 * @author jerry.R
 */

public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        Long userId = 20L;
        LOGGER.info("test,userId={}",  userId);
        LOGGER.info("UserId:{},{},{}", "1", "longwentao1999", "abcdefg");
    }
}
