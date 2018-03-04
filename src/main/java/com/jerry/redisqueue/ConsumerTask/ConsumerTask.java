package com.jerry.redisqueue.ConsumerTask;

import com.jerry.cn.redisqueue.jedis.JedisFactory;
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
            for (String topicContent : list) {
                System.out.println(topicContent);
            }
            //jedisClient.close();
        }
    }
}
