package com.jerry.redisqueue.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Date: 17/9/18 12:38
 *
 * @author jerry.R
 */

public class JedisFactory {
    private JedisFactory() {

    }

    public static JedisPool getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000 * 100);
        config.setTestOnBorrow(true);
        return new JedisPool(config, "localhost", 6379, 2 * 6000);
    }

    public static Jedis getJedisClient(JedisPool jedisPool) {
        return jedisPool.getResource();

    }
}
