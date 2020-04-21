package tv.dzj.java.cache;

import com.google.common.cache.*;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author dzj
 * @date 2020/4/21 0:22
 */
public class GuavaExample {

    public static void main(String[] args) throws Exception{
        //一、LoadingCache
        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                //并发级别设置为5，是指可以同时写缓存的线程数
                .concurrencyLevel(5)
                //设置8秒过期时间
                .expireAfterWrite(8, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为 10
                .initialCapacity(10)
                //设置缓存最大容器为100，超过之后按照LRU算法移除缓存项
                .maximumSize(100)
                //设置要统计缓存的命中率
                .recordStats()
                //设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object,Object> notification){
                        //some log
                    }
                })
                //指定CacheLoader，缓存不存在时，可自动加载缓存
                .build(
                        new CacheLoader<String, String>() {

                            @Override
                            public String load(String s) throws Exception {
                                return s;
                            }
                        }
                );
        //设置缓存
        loadingCache.put("c1","hello c1");
        //查询缓存
        loadingCache.get("c1");

        //创建模式二 Callable
        Cache<String, String> cache = CacheBuilder.newBuilder()
                //设置缓存最大长度
                .maximumSize(2)
                .build();
        //设置缓存
        cache.put("k1","hello k1");
        //查询缓存
        cache.get("k1", new Callable<String>() {
            public String call(){
                //缓存不存在时
                return "nil";
            }
        });
    }
}
