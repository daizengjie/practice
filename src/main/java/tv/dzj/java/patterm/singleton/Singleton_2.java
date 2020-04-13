package tv.dzj.java.patterm.singleton;

/**
 * 懒汉，线程安全，效率低
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class Singleton_2 {

    private static Singleton_2 singleton;

    private Singleton_2(){

    }

    public static synchronized Singleton_2 getInstance(){
        if(singleton == null){
            singleton = new Singleton_2();
        }
        return singleton;
    }
}
