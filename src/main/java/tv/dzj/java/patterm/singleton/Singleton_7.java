package tv.dzj.java.patterm.singleton;

/**
 * 双重检验锁
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class Singleton_7 {
    private volatile static Singleton_7 instance;

    private Singleton_7(){}

    public static Singleton_7 getInstance(){
        if(instance == null){
            synchronized (Singleton_7.class){
                if(instance == null){
                    instance = new Singleton_7();
                }
            }
        }
        return instance;
    }
}
