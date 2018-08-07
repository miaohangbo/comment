package com.example.util.Cache;/*
package com.example.util.Cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


*/
/**
 * redies工具类
 * @author 1
 *
 *//*


@Service
public class RedisTemplateUtils {
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;
	
    */
/**
     * 写入缓存 
     * 
     * @param key 
     * @param value 
     * @param expire 
     *//*

    public  void set(final String key, final Object value, final long expire) {  
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);  
    }  
  
    */
/**
     * 读取缓存 
     *  
     * @param key 
     * @param clazz 
     * @return 
     *//*

    @SuppressWarnings("unchecked")  
    public  <T> T get(final String key, Class<T> clazz) {  
        return (T) redisTemplate.boundValueOps(key).get();  
    }  
      
    */
/**
     * 读取缓存 
     * @param key 
     * @return 
     *//*

    public  Object getObj(final String key){  
        try {
            return redisTemplate.boundValueOps(key).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  
    }  
  
    */
/**
     * 删除，根据key精确匹配 
     *  
     * @param key 
     *//*

    public  void del(final String... key) {  
        redisTemplate.delete(Arrays.asList(key));  
    }  
  
    */
/**
     * 批量删除，根据key模糊匹配 
     * @param pattern 
     *//*

    public  void delpn(final String... pattern) {  
        for (String kp : pattern) {  
            redisTemplate.delete(redisTemplate.keys(kp + "*"));  
        }  
    }  
  
    */
/**
     * key是否存在 
     * @param key 
     *//*

    public  boolean exists(final String key) {  
        return redisTemplate.hasKey(key);  
    }  
    
    public static void main(String[] args){
    	
    }

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}
	
	 */
/**
     * 读取缓存 
     * @param key 
     * @return 
     *//*

    public  String getString(final String key){  
        return redisTemplate.boundValueOps(key).get(0,-1);  
    }  
    */
/**
     * 
     * @param key
     * @param hashKey
     * @return
     *//*

    public Object getHashValue(String key, Object hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}
    */
/**
     * 
     * @param key
     * @return
     *//*

	public List<Object> getHashValues(String key) {
		return redisTemplate.opsForHash().values(key);
	}
	*/
/**
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 *//*

	public void putHash(String key, Object hashKey, Object value) {
		redisTemplate.opsForHash().put(key, hashKey, value);
	}
	*/
/**
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 * @return
	 *//*

	public boolean putHashIfAbsent(String key, Object hashKey, Object value) {
		return redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
	}
	*/
/**
	 * 
	 * @param key
	 * @param m
	 *//*

	public void putHashAll(String key, Map<String, Object> m) {
		redisTemplate.opsForHash().putAll(key, m);
	}
	*/
/**
	 * 
	 * @param key
	 * @param obj
	 * @return
	 *//*

	public Object getAndSet(String key, Object obj) {
		return redisTemplate.opsForValue().getAndSet(key, obj);
	}
	*/
/**
	 * 
	 * @param key
	 * @param obj
	 * @return
	 *//*

	public boolean setIfAbsent(String key, Object obj) {
		return redisTemplate.opsForValue().setIfAbsent(key, obj);
	}
	*/
/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 *//*

	public Object rightPush(String key, Object value) {
		return redisTemplate.opsForList().rightPush(key, value);
	}

	*/
/**
	 * @param key
	 * @param start
	 * @param end
	 *//*

	public void range(String key, int start, int end) {
		redisTemplate.opsForList().range(key, start, end);
	}
    
}
*/
