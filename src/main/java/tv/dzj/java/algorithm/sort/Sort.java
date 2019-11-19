package tv.dzj.java.algorithm.sort;

/**
 * 排序抽象类
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public abstract class Sort <T extends Comparable<T>>{
    public abstract void sort(T[] nums);

    protected boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
