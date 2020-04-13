package tv.dzj.java.leetcode;

import java.util.Arrays;

/**
 * Kth Element
 * 215. Kth Largest Element in an Array (Medium)
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * 题目描述：找到倒数第 k 个的元素。
 *
 * 排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)
 *
 * 快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
 *
 * @author dzj
 */
public class KthElement {

    public int findKthElement1(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthElement2(int[] nums, int k){
        return 0;
    }

}
