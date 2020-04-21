package tv.dzj.java.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author dzj
 * @date 2020/4/21 6:20
 */
public class CacheGlobal {
    /**
     * 全局缓存对象
     */
    public static ConcurrentMap<String, CacheValue> concurrentMap = new ConcurrentHashMap<String, CacheValue>();
}
