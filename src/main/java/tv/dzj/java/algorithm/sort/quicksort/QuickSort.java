package tv.dzj.java.algorithm.sort.quicksort;

import tv.dzj.java.algorithm.sort.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 * 将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素
 * 将这两个子数组排序也就将整个数组排序了。
 *
 * 性能分析：
 * 快速排序是原地排序，不需要辅助数组，但是递归调用需要辅助栈。
 * 在进行快速排序时需要随机打乱数组。
 * 最好情况是O(NlogN) 最坏情况是O(N^2)
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums,0,nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if(l <= h){
            return;
        }
        int j = partition(nums,l,h);
        sort(nums,l,j-1);
        sort(nums,j+1,h);
    }

    private int partition(T[] nums, int l, int h) {
        int i = 1;
        int j = h + 1;
        T v = nums[l];
        while(true){
            while(less(nums[++i],v) && i != h) ;
            while(less(v,nums[--j]) && j != l) ;
            if(i >= j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,1,j);
        return j;
    }

    /**
     * 随机打乱顺序
     * @param nums nums
     */
    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}
