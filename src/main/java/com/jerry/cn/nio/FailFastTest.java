package com.jerry.cn.nio;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Date: 17/9/17 11:07
 *
 * @author jerry.R
 */

public class FailFastTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "23");
        map.put("2", "23");
        map.put("3", "23");

        Iterator iterator = map.entrySet().iterator();
        //remove iterator
       /* while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
            iterator.remove();
        }*/
        //fail_fast
       /* while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
            map.remove("1");
        }*/
       /* List<String> list = new ArrayList<>();
        list.add("12132");
        list.add("12121332");
        list.add("12213132");
        Iterator iterator1=list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next().toString());
            list.remove(1);
        }*/


        List<String> copyArryList = new CopyOnWriteArrayList<>();
        copyArryList.add("1");
        copyArryList.add("2");
        copyArryList.add("5");
        copyArryList.add("6");
        Iterator iterator2 = copyArryList.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
            //copyArryList.add("test");
            System.out.println(copyArryList.remove("1"));//boolean

        }

    }
}
