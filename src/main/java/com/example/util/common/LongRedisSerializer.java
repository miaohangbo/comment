package com.example.util.common;/*
package com.example.util.common;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

*/
/**
 * Created by MaYong on 2018/1/16.
 *//*

public class LongRedisSerializer implements RedisSerializer<Long> {
    @Override
    public byte[] serialize(Long aLong) throws SerializationException {
        byte[] bytes = null;
        if (aLong != null) {
            bytes = String.valueOf(aLong).getBytes();
        }
        return bytes;
    }

    @Override
    public Long deserialize(byte[] bytes) throws SerializationException {
        Long value = null;
        if (bytes != null) {
            value = Long.valueOf(new String(bytes));
        }
        return value;
    }
}
*/
