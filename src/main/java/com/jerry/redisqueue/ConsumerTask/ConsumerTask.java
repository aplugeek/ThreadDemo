package com.jerry.redisqueue.ConsumerTask;

import com.jerry.redisqueue.jedis.JedisFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Date: 17/9/18 12:45
 *
 * @author jerry.R
 */

public class ConsumerTask implements Runnable {
    private Jedis jedisClient = JedisFactory.getJedisClient(JedisFactory.getJedisPool());

    @Override
    public void run() {
        while (true) {
            //blocked while testQueue is null
            List<String> list = jedisClient.brpop(0, "testQueue");
            System.out.println(list.get(1));
            Integer count = 0;
            if (list.get(1).split("\\[").length >= 2) {
                count = Integer.valueOf(list.get(1).split("\\[")[1].replace("]", ""));
            }
            String realContent = list.get(1).replaceAll("\\[\\d*]$", "");
            if (Integer.valueOf(realContent) % 2 == 0) {
                if(count<10)
                jedisClient.lpush("testQueue", String.format(realContent + "[%d]", count + 1));
            }
            //jedisClient.close();
        }
    }
}
