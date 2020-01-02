package tv.dzj.java.leetcode;

/**
 * 167. Two Sum II - Input array is sorted (Easy)
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 解题思路：
 *      使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。
 *      指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 * 如果 sum > target，移动较大的元素，使 sum 变小一些；
 * 如果 sum < target，移动较小的元素，使 sum 变大一些。
 *
 * 复杂度：时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target){
        if(numbers == null){
            return null;
        }
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1, j+1};
            }else if ( sum > target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}
