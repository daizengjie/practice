package tv.dzj.java.algorithm.sort.merge;

import tv.dzj.java.algorithm.sort.merge.Merge;

/**
 * 自顶而下归并排序
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends Merge<T> {
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
    }
    private void sort(T[] nums, int l, int h){

    }
}
