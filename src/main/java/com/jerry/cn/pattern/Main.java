package com.jerry.cn.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date: 2017/10/20 11:48
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(^[a-z])+(\\d+)");
        Matcher matcher = pattern.matcher("asdsdadsad12321");
        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());

    }
}
