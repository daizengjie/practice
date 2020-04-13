package tv.dzj.java.patterm.singleton;

/**
 * 饿汉 （变种）
 * 在类初始化即实例化instance
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class Singleton_4 {

    private static Singleton_4 instance;

    static {
        instance = new Singleton_4();
    }

    private Singleton_4(){}

    public static Singleton_4 getInstance(){
        return instance;
    }
}
