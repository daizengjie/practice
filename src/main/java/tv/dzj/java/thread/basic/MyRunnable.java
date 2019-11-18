package tv.dzj.java.thread.basic;

/**
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class MyRunnable implements Runnable{
    public void run() {
        //...
    }

    public static void main(String[] args){
        MyRunnable mr = new MyRunnable();
        //最好使用线程池
        Thread thread = new Thread(mr);
        thread.start();
    }
}
