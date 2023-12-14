package com.gooluke.core.integration.dao.impl;

import com.gooluke.core.integration.dao.RedisDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

/**
 * @author 咕噜科
 * ClassName: RedisDAOImpl
 * date: 2023-11-01 0:55
 * Description:
 * version 1.0
 */
@Component
public class RedisDAOImpl implements RedisDAO {

    private static final Logger log = LoggerFactory.getLogger(RedisDAOImpl.class);

    @Autowired
    private JedisPool jedisPool;

    @Override
    public boolean set(String key, String value, Long expireTime) {
        try (Jedis jedis = jedisPool.getResource()) {
            SetParams params = new SetParams();
            params.ex(expireTime);
            String result = jedis.set(key, value, params);
            if ("OK".equals(result)) {
                return true;
            }
        } catch (Exception e) {
            log.error("redis set error:", e);
        }
        return false;
    }

    @Override
    public boolean setNx(String key, String value, Long expireTime) {
        try (Jedis jedis = jedisPool.getResource()) {
            SetParams params = new SetParams();
            params.nx();
            params.ex(expireTime);
            String result = jedis.set(key, value, params);
            if ("OK".equals(result)) {
                return true;
            }
        } catch (Exception e) {
            log.error("redis setNx error:", e);
        }
        return false;
    }

    @Override
    public boolean lockKey(String key, String value, Long expireTime) {
        return setNx(key, value, expireTime);
    }

    @Override
    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch (Exception e) {
            log.error("redis get error:", e);
        }
        return null;
    }

    @Override
    public long delete(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(key);
        } catch (Exception e) {
            log.error("redis del error:", e);
        }
        return 0;
    }


}
