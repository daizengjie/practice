package tv.dzj.java.algorithm.threesum;

import java.util.Arrays;

/**
 * 先排序再二分查找
 * @author dzj
 */
public class ThreeSumBinarySearch implements ThreeSum {
    public int count(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int cnt = 0;
        for(int i = 0; i < N;i++){
            for(int j = 0; i < N; j++){
                int target = -nums[i]-nums[j];
                int index = BinarySearch.search(nums,target);
                if(index > j){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
