package com.example.util.Cache;/*package com.lanxiong.util.Cache;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository(value = "redisDao")
public class RedisDao {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RedisDao.class);
    @Autowired  
    private  ShardedJedisPool shardedJedisPool;  
    	private static ShardedJedis instance = null;
	public static  ShardedJedis getInstance(){
        if(instance == null){
            instance = shardedJedisPool.getResource();
        }
        return instance;
    }
    *//**
     * 
	  //jedis.set(key.getBytes(), SerializingUtil.serialize(actual));
	  // Userinfo expected = (Userinfo) SerializingUtil.deserialize(jedis.get(key.getBytes()));
     * @author shihb
     * @date 2015-8-5 上午10:47:06
     *//*

    public int getIndexDB() {
        return ResourceUtil.getConfigRedis("redis.db");
    }

    public void set(String key, String value)  { 
        ShardedJedis jedis=null;
        try {
            jedis =  shardedJedisPool.getResource();
            selectDB(jedis,getIndexDB());  
            jedis.set(key, value);
        }finally{
            if(jedis!=null)
                shardedJedisPool.returnResource(jedis);
        }


    } 
    
    *//**
     * 向redis 放数据 存在返回0 并且数据不能放入
     * @Title:        setnx 
     * @Description:  TODO
     * @param key
     * @param value    (para中每个参数的中文名称,return中的具体内容)  
     * @author        shihb
     * @Date          2015-11-19 下午2:53:05
     *//*
    public long setnx(String key, String value, int seconds)  { 
        ShardedJedis jedis=null;
        long s=0;
        try {
            long link=System.currentTimeMillis();
            jedis =  shardedJedisPool.getResource();
            LOGGER.info(s+"++++++++++"+key+"----连接redis库消耗【"+(System.currentTimeMillis()-link)+"】毫秒");
            long linka=System.currentTimeMillis();
            selectDB(jedis,getIndexDB());
            LOGGER.info(s+"++++++++++"+key+"----redis切库消耗【"+(System.currentTimeMillis()-linka)+"】毫秒");
            long start=System.currentTimeMillis();
            s=jedis.setnx(key, value);
            LOGGER.info(s+"++++++++++"+key+"----放入redis库消耗【"+(System.currentTimeMillis()-start)+"】毫秒");
            long linkb=System.currentTimeMillis();
            jedis.expire(key, seconds);
            LOGGER.info(s+"++++++++++"+key+"----redis设置过期时间【"+(System.currentTimeMillis()-linkb)+"】毫秒");
            
        }finally{
            if(jedis!=null)
                shardedJedisPool.returnResource(jedis);
        }
        return s;
    }
    *//**
     * 向redis 放数据 存在返回0 并且数据不能放入
     * @Title:        setnx 
     * @Description:  TODO
     * @param key
     * @param value    (para中每个参数的中文名称,return中的具体内容)  
     * @author        shihb
     * @Date          2015-11-19 下午2:53:05
     *//*
    public long setnx(String key, String value)  { 
        ShardedJedis jedis=null;
        long s=0;
        try {
            long link=System.currentTimeMillis();
            jedis =  shardedJedisPool.getResource();
            LOGGER.info(s+"++++++++++"+key+"----连接redis库消耗【"+(System.currentTimeMillis()-link)+"】毫秒");
            long linkb=System.currentTimeMillis();
            selectDB(jedis,getIndexDB());
            LOGGER.info(s+"++++++++++"+key+"----redis切库消耗【"+(System.currentTimeMillis()-linkb)+"】毫秒");
            long start=System.currentTimeMillis();
            s=jedis.setnx(key, value);
            LOGGER.info(s+"++++++++++"+key+"----放入redis库消耗【"+(System.currentTimeMillis()-start)+"】毫秒");
        }finally{
            if(jedis!=null)
                shardedJedisPool.returnResource(jedis);
        }
        return s;
    }
    *//**
     * 根据主键 获取数据
     * @return    (para中每个参数的中文名称,return中的具体内容)  
     * @author        shihb
     * @Date          2015-11-30 下午3:52:01
     *//*
    public String get(String key)  {    
        ShardedJedis jedis=null;
        try {
            jedis =  shardedJedisPool.getResource();
            selectDB(jedis,getIndexDB());  
            String value= jedis.get(key);  
            return value;
        }finally{
            if(jedis!=null)
                shardedJedisPool.returnResource(jedis);
        }

    }
    *//**
     * @Title:        delKey 
     * @Description:  删除key
     * @param key
     * @author        shihb
     * @Date          2015-12-1 上午10:18:53
     *//*
    public void delKey(String key) {
        ShardedJedis jedis=null;
        try {
            long link=System.currentTimeMillis();
            jedis =  shardedJedisPool.getResource();
            if((System.currentTimeMillis()-link)>50){
             LOGGER.info("========="+key+"----连接redis库消耗【"+(System.currentTimeMillis()-link)+"】毫秒");
            }
            long start=System.currentTimeMillis();
            selectDB(jedis,getIndexDB()); 
            if((System.currentTimeMillis()-start)>50){
            LOGGER.info("========="+key+"----redis切库消耗【"+(System.currentTimeMillis()-start)+"】毫秒");
            }
            long del=System.currentTimeMillis();
            jedis.del(key);
            if((System.currentTimeMillis()-del)>50){
            LOGGER.info("========="+key+"----redis删除key库消耗【"+(System.currentTimeMillis()-del)+"】毫秒");
            }
        }finally{
            if(jedis!=null)
                shardedJedisPool.returnResource(jedis);
        }
    }  
    
    *//**
     * 设置key 的超时时间
     * @Title:        setKeyExpire 
     * @Description:  TODO
     * @param key
     * @param seconds    (para中每个参数的中文名称,return中的具体内容)  
     * @author        shihb
     * @Date          2015-12-1 上午10:18:53
     *//*
    public void setKeyExpire(String key, int seconds) {
        ShardedJedis jedis=null;
        try {
            jedis =  shardedJedisPool.getResource();
            selectDB(jedis,getIndexDB());  
            jedis.expire(key, seconds);
        }finally{
            if(jedis!=null)
                shardedJedisPool.returnResource(jedis);
        }
    }  
    *//**
     * 切换 redis 库 （0-15）
     * @param jedis
     * @param dbIndex    (para中每个参数的中文名称,return中的具体内容)  
     * @author        shihb
     * @Date          2015-11-30 下午3:52:31
     *//*
    private void selectDB(ShardedJedis jedis,int dbIndex) {
        Collection<Jedis> js=jedis.getAllShards();  
        Iterator<Jedis> it=js.iterator();  
        while(it.hasNext()){  
            Jedis j=it.next();  
            j.select(dbIndex); 
        }
    } 
    
   
}
*/