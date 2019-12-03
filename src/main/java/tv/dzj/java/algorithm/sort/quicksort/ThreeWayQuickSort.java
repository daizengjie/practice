package tv.dzj.java.algorithm.sort.quicksort;

/**
 * 三向切分
 * 将数组切分为三部分，分别对应小于、等于和大于切分元素
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {
    protected void sort(T[] nums, int l, int h){
        if(h <= l){
            return;
        }
        int lt = l;
        int i = l+1;
        int gt = h;
        T v = nums[l];
        while(i <= gt){
            int cmp = nums[i].compareTo(v);
            if(cmp < 0){

            }
        }
    }
}
