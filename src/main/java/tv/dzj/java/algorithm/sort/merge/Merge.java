package tv.dzj.java.algorithm.sort.merge;

import tv.dzj.java.algorithm.sort.Sort;

/**
 * 归并排序
 * 将数组分成两部分，分别进行排序，然后归并起来。
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public abstract class Merge<T extends Comparable<T>> extends Sort<T> {
    /**
     * 辅助数组
     */
    protected T[] aux;

    protected void merge(T[] nums,int l, int m, int h){
        int i = l;
        int j = m+1;
        for(int k = l; k <= h; k++){
            //将数据复制到辅助数组
            aux[k] = nums[k];
        }
    }
}
