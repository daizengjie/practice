package tv.dzj.java.algorithm.sort.heap;

import tv.dzj.java.algorithm.sort.Sort;

/**
 * 堆
 *  堆是完全二叉树，堆的某节点的值大于等于子节点的值，而完全二叉树很容易就存储在数组中。数组索引从1开始
 *  位置 k 的节点的父节点位置为 k/2，而它的两个子节点的位置分别为 2k 和 2k+1。
 *  数组第0个位置不能有元素
 *
 * 堆排序
 *  构建堆
 *  交换堆顶元素与最后一个元素
 *  交换之后进行下沉操作
 * @author dzj
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        //TODO 从数组一半开始做下沉操作，形成完整的堆 ？？
        for(int k = N / 2; k >= 1; k--){
            sink(nums, k, N);
        }
        while(N > 1){
            swap(nums,1, N--);
            sink(nums,1,N);
        }
    }

    private void sink(T[] nums, int k, int N){
        while(2 * k <= N){
            int j = 2 * k;
            if(j < N && less(nums, j, j+1)){
                j++;
            }
            if(!less(nums,k,j)){
                break;
            }
            swap(nums,k,j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i,int j){
        return nums[i].compareTo(nums[j]) < 0;
    }
}
