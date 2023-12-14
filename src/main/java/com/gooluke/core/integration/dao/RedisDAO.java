package com.gooluke.core.integration.dao;

/**
 * @author 咕噜科
 * ClassName: RedisDAO
 * date: 2023-11-01 0:55
 * Description:
 * version 1.0
 */
public interface RedisDAO {

    boolean set(String key, String value, Long expireTime);

    boolean setNx(String key, String value, Long expireTime);
    boolean lockKey(String key, String value, Long expireTime);

    String get(String key);

    long delete(String key);

}
