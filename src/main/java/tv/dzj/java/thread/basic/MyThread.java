package tv.dzj.java.thread.basic;

/**
 * @author dzj
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        //...
    }
    public static void main(String[] args){
        MyThread mt = new MyThread();
        //最好使用线程池
        Thread thread = new MyThread();
        thread.start();
    }
}
