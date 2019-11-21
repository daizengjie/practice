package tv.dzj.java.algorithm.sort.shell;

import tv.dzj.java.algorithm.sort.Sort;

/**
 * 希尔排序
 * 使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while(h < N / 3){
            h = 3 * h + 1;
        }
        while(h >= 1){
            for(int i = h;i < N;i++){
                for(int j = i;j >= h && less(nums[j],nums[j-h]);j -= h){
                    swap(nums,j,j-h);
                }
            }
            h = h / 3;
        }
    }
}
