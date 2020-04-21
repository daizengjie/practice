package tv.dzj.java.cache;

import org.apache.commons.lang3.StringUtils;
import sun.misc.Cache;

import java.util.concurrent.TimeUnit;

/**
 * @author dzj
 * @date 2020/4/21 6:56
 */
public class CacheUtils {
    public void put(String key, Object value, long expire){
        //非空判断
        if(StringUtils.isBlank(key)){
            return;
        }
        //当缓存存在时，更新缓存
        if(CacheGlobal.concurrentMap.containsKey(key)){
            CacheValue cache = CacheGlobal.concurrentMap.get(key);
            cache.setHitCount(cache.getHitCount() + 1);
            cache.setWriteTime(System.currentTimeMillis());
            cache.setLastTime(System.currentTimeMillis());
            cache.setExpireTime(expire);
            cache.setValue(value);
            return;
        }
        //创建缓存
        CacheValue cache = new CacheValue();
        cache.setKey(key);
        cache.setValue(value);
        cache.setWriteTime(System.currentTimeMillis());
        cache.setLastTime(System.currentTimeMillis());
        cache.setHitCount(1);
        cache.setExpireTime(expire);
        CacheGlobal.concurrentMap.put(key, cache);
    }

    public Object get(String key){
        //非空判断
        if (StringUtils.isBlank(key)){
            return null;
        }
        //字典中不存在
        if (CacheGlobal.concurrentMap.isEmpty()){
            return null;
        }
        if (!CacheGlobal.concurrentMap.containsKey(key)){
            return null;
        }
        CacheValue cache = CacheGlobal.concurrentMap.get(key);
        if(cache == null){
            return null;
        }
        //惰性删除
        long timeout = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - cache.getWriteTime());
        if(cache.getExpireTime() <= timeout){
            CacheGlobal.concurrentMap.remove(key);
            return null;
        }
        cache.setHitCount(cache.getHitCount() + 1);
        cache.setLastTime(System.currentTimeMillis());
        return cache.getValue();
    }
}
