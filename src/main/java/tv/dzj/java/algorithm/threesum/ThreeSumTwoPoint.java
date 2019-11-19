package tv.dzj.java.algorithm.threesum;

import java.util.Arrays;

/**
 * 先排序再双指针
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class ThreeSumTwoPoint implements ThreeSum{
    public int count(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int cnt = 0;
        for(int i = 0; i < N - 2; i++){
            int l = i + 1;
            int h = N - 1;
            int target = -nums[i];
            while(l < h){
                int sum = nums[l] + nums[h];
                if(sum == target){
                    cnt++;
                    l++;
                    h--;
                }else if (sum < target){
                    l++;
                }else{
                    h--;
                }
            }
        }
        return cnt;
    }
}
