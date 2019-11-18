package tv.dzj.java.thread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class MyCallable implements Callable<Integer> {
    public Integer call(){
        return 1;
    }
    public static void main(String[] args) throws Exception{
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<Integer>(mc);
        //最好使用线程池
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
