package tv.dzj.java.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author dzj
 * @date 2020/4/21 21:42
 */
@Slf4j
public class CustomDelayQueue {
    /**
     * 延时消息队列
     */
    private static DelayQueue delayQueue = new DelayQueue();

    public static void main(String[] args) throws InterruptedException{
        producer();
        consumer();
    }

    private static void consumer() throws InterruptedException{
        while (!delayQueue.isEmpty()) {
            delayQueue.take();
        }
    }

    private static void producer() {
        delayQueue.put(new MyDelay(1000, "消息1"));
        delayQueue.put(new MyDelay(3000, "消息2"));
    }

    static class MyDelay implements Delayed{

        //延迟截止时间
        long delayTime = System.currentTimeMillis();

        @Getter
        @Setter
        private String msg;

        /**
         * 初始化
         * @param delayTime 设置延迟执行时间
         * @param msg 执行的消息
         */
        public MyDelay(long delayTime, String msg){
            this.delayTime = (this.delayTime + delayTime);
            this.msg = msg;
        }

        /**
         * 获取剩余时间
         * @param unit unit
         * @return long
         */
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime - System.currentTimeMillis(),TimeUnit.SECONDS);
        }

        /**
         * 队列里的排序顺序
         * @param o o
         * @return int
         */
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)){
                return 1;
            }else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
