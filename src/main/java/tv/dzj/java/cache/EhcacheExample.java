package tv.dzj.java.cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * @author dzj
 * @date 2020/4/20 22:33
 */
public class EhcacheExample {
    public static void main(String[] args) {
        //创建缓存管理器
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        //初始化Ehcache
        cacheManager.init();
        //创建缓存存储器
        //设置缓存的最大容量
        Cache<String,String> myCache = cacheManager.createCache("MYCACHE",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        String.class,String.class, ResourcePoolsBuilder.heap(10)
                ));
        //设置缓存
        myCache.put("key","Hello,Java.");
        //读取缓存
        String value = myCache.get("key");
        //关闭缓存
        cacheManager.close();
    }
}
