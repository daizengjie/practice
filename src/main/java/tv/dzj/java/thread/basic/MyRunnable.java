package tv.dzj.java.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class MyRunnable implements Runnable{
    public void run() {
        //...

        //当前线程已经完成了生命周期中最重要的部分，可以切换给其它线程来执行，该方法只是对线程调度器的一个建议
        Thread.yield();

        //...
    }

    public static void main(String[] args){
        //最好使用手动创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
