package tv.dzj.java.patterm.singleton;

/**
 * 饿汉
 * 基于classloder机制避免了多线程的同步问题
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class Singleton_3 {

    private static Singleton_3 singleton = new Singleton_3();

    private Singleton_3(){}

    public static Singleton_3 getInstance(){
        return singleton;
    }
}
