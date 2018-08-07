package com.example.util.Cache;/*
package com.example.util.Cache;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

*/
/**
 * Created by liwd on 2017/8/1.
 *//*

@Service
public class RedisTestService implements InitializingBean,Runnable{

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void run() {
        //redis使用测试
        System.out.println("redis test.....");
        //操作字符串
        ValueOperations<String,String> valueOperations= redisTemplate.opsForValue();
        valueOperations.set("name","tom",120, TimeUnit.SECONDS);
        System.out.println("{key=name,value=tom},is putted to redis.");
        String name=valueOperations.get("name");
        System.out.println("{key=name}，is getted value="+name);

        //操作hash
        HashOperations<String,String,Object> hashOperations=redisTemplate.opsForHash();
        Map<String,Object> user = new HashMap();
        user.put("name","tom");
        user.put("sex","male");
        user.put("age",27);
        hashOperations.putAll("uid_1",user);
        redisTemplate.expire("uid_1",120,TimeUnit.SECONDS);
        System.out.println("hash putted by uid_1,"+user);
        Map<String,Object> retmap=hashOperations.entries("uid_1");
        System.out.println("hash getted by uid_1,"+retmap);

        //操作list
        ListOperations<String,String> listOperations=redisTemplate.opsForList();
        listOperations.rightPush("uids_queue","1");
        System.out.println("1 pushed to uids_queue.");
        listOperations.rightPush("uids_queue","2");
        System.out.println("2 pushed to uids_queue.");
        redisTemplate.expire("uid_queue",120,TimeUnit.SECONDS);
        String value=listOperations.leftPop("uids_queue");
        System.out.println("uids_queue poped value "+value);
        String value1=listOperations.leftPop("uids_queue");
        System.out.println("uids_queue poped value "+value1);
        //操作set
        SetOperations<String,String> setOperations=redisTemplate.opsForSet();
        //操作有序set
        ZSetOperations<String,String> zSetOperations=redisTemplate.opsForZSet();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.schedule(this,20, TimeUnit.SECONDS);
    }



}
*/
