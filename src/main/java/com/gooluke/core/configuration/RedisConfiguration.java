package com.gooluke.core.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author gooluke
 * date: 2023-12-15 1:01
 * Description:
 * version
 */
@Configuration
public class RedisConfiguration {

    @Bean("goolukeJedisPool")
    public JedisPool goolukeJedisPool (@Value("${redis.host}") String host,
                                       @Value("${redis.port}") int port,
                                       @Value("${redis.max-total:10}") int maxTotal,
                                       @Value("${redis.max-idle:5}") int maxIdle,
                                       @Value("${redis.min-idle:1}") int minIdle
    ) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal); // 最大连接数
        poolConfig.setMaxIdle(maxIdle); // 最大空闲连接数
        poolConfig.setMinIdle(minIdle); // 最小空闲连接数
        return new JedisPool(poolConfig, host, port);
    }

}
