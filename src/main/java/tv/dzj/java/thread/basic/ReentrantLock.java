package tv.dzj.java.thread.basic;

/**
 * @author dzj
 * @date 2020/4/14 1:21
 */
public class ReentrantLock {

    public static void main(String[] args) {
        reentrantA();
    }

    private synchronized static void reentrantA() {
        System.out.println(Thread.currentThread().getName()+ "reentrantA");
        reentrantB();
    }

    private synchronized static void reentrantB() {
        System.out.println(Thread.currentThread().getName() + "reentrantB");

    }
}
