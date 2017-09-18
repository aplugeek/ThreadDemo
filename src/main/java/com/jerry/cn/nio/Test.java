package com.jerry.cn.nio;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 17/9/17 11:07
 *
 * @author jerry.R
 */

public class Test {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("1","23");
        map.put("2","23");
        map.put("3","23");

        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry);
            //fail_safe  actually operate  the copy of map
            map.put("1", "234");
        }
        System.out.println(map.get("1"));
    }
}
