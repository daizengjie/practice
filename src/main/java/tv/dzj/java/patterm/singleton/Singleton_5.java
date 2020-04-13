package tv.dzj.java.patterm.singleton;

/**
 * 静态内部类
 * 利用了classloder的机制来保证初始化instance时只有一个线程
 * Singleton类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用
 * 只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance
 * @author dzj
 */
public class Singleton_5 {

    private static class SingletonHolder{
        private static final Singleton_5 INSTANCE = new Singleton_5();
    }

    private Singleton_5(){

    }

    public static final Singleton_5 getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
