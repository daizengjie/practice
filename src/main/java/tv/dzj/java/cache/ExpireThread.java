package tv.dzj.java.cache;

import java.util.concurrent.TimeUnit;

/**
 * @author dzj
 * @date 2020/4/21 6:46
 */
public class ExpireThread implements Runnable{

    public void run() {
        while(true){
            try {
                //每十秒检测一次
                TimeUnit.SECONDS.sleep(10);
                //缓存检测和清除方法
                expireCache();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void expireCache() {
        for(String key : CacheGlobal.concurrentMap.keySet()){
            CacheValue cacheValue = CacheGlobal.concurrentMap.get(key);
            long timeout = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - cacheValue.getWriteTime());
            if(cacheValue.getExpireTime() > timeout){
                continue;
            }
            //清理过期缓存
            CacheGlobal.concurrentMap.remove(key);
        }
    }
}
