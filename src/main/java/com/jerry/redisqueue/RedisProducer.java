package com.jerry.redisqueue;

import com.jerry.cn.redisqueue.jedis.JedisFactory;
import com.jerry.redisqueue.jedis.JedisFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Date: 17/9/18 12:20
 * redis queue Producer
 *
 * @author jerry.R
 */

public class RedisProducer {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisFactory.getJedisPool();
        Jedis jedisClient = JedisFactory.getJedisClient(jedisPool);
        redisQueue(jedisClient);
        jedisClient.close();


    }

    /**
     * write queue to redis
     *
     * @param jedisClient jedisClient
     */
    private static void redisQueue(Jedis jedisClient) {
        for (int i = 0; i < 10; i++) {
            jedisClient.lpush("testQueue", "value2_" + i);
        }
    }
}
