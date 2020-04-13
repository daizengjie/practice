package tv.dzj.java.patterm.singleton;

/**
 * 懒汉，线程不安全
 * @author dzj
 */
public class Singleton_1 {

    private static Singleton_1 singleton;

    private Singleton_1(){
    }

    public static Singleton_1 getInstance(){
        if(singleton == null){
            singleton = new Singleton_1();
        }
        return singleton;
    }
}
