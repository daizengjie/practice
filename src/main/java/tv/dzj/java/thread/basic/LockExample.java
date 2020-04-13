package tv.dzj.java.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * @author dzj
 * @date 2020/4/13 17:39
 */
public class LockExample {
    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(() -> {
            synchronized (lock1){
                System.out.println("获取 lock1 成功");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock2){
                System.out.println("获取 lock2 成功");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
