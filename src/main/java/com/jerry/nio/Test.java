package com.jerry.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Date: 2018/2/9 23:19
 *
 * @author jerry.R
 */

public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        Map<Integer, Long> teamMap = new HashMap<>();
        teamMap.put(1, 1L);
        teamMap.put(2, 2L);
        teamMap.put(3, 3L);
        teamMap.put(4, 4L);
        teamMap.put(5, 5L);
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        teamMap.forEach((k, v) -> {
            for (Long i = 0L; i < v; i++) {
                randomList.add(k);
            }
        });

        Map<Integer, Long> countStastic = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            int curator = random.nextInt(randomList.size());
            if(countStastic.get(randomList.get(curator))==null){
                countStastic.put(randomList.get(curator), 1L);
            }else {
                countStastic.put(randomList.get(curator), countStastic.get(randomList.get(curator)) + 1);
            }
        }
        System.out.println(countStastic);
    }
}
