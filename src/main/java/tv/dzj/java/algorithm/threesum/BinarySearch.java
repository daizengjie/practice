package tv.dzj.java.algorithm.threesum;

/**
 * 二分查找
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class BinarySearch {
    public static int search(int[] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        while(l <= h){
            int m = l + (h-1) /2;
            if(target == nums[m]){
                return m;
            }else if(target > nums[m]){
                l = m + 1;
            }else {
                h = m - 1;
            }
        }
        return -1;
    }
}
