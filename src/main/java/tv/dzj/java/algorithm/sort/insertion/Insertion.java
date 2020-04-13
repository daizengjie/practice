package tv.dzj.java.algorithm.sort.insertion;

import tv.dzj.java.algorithm.sort.Sort;

/**
 * 插入排序
 * 插入到左侧已经排序的数组，使得插入之后左侧数组依然有序。
 * @author dzj
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for(int i = 1;i < N;i++){
            for(int j = i;j > 0 && less(nums[j],nums[j-1]); j--){
                swap(nums,j,j-1);
            }
        }
    }
}
