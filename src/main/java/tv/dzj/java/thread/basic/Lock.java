package tv.dzj.java.thread.basic;

/**
 * @author dzj
 * @date 2020/4/14 1:06
 */
public class Lock {
    public static void main(String[] args) {
        synchronized (Lock.class){
            System.out.println("lock");
        }
    }
}
