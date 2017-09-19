package com.jerry.cn.nio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Date: 17/9/17 11:07
 *
 * @author jerry.R
 */

public class FailFastTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("1","23");
        map.put("2","23");
        map.put("3","23");

        /*for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry);
            //fail_safe  actually operate  the copy of map
            //map.put("1", "234");
            map.remove("1");// throw concurrentException
        }*/

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        for (Iterator iterator1=map.entrySet().iterator();iterator1.hasNext();){
            System.out.println(iterator1.next());
            iterator1.remove();
        }

        System.out.println(map.get("1"));
        System.out.println(map.size());
    }
}
