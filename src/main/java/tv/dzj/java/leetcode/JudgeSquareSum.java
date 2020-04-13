package tv.dzj.java.leetcode;

/**
 * 633. Sum of Square Numbers (Easy)
 * 题目描述：判断一个非负整数是否为两个整数的平方和。
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 可以看成是在元素为 0~target 的有序数组中查找两个数，使得这两个数的平方和为 target,
 * 如果能找到，则返回 true，表示 target 是两个整数的平方和。
 * 右指针的初始化，实现剪枝，从而降低时间复杂度。
 * 设右指针为 x，左指针固定为 0，为了使 0^2 + x^2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
 *
 * 复杂度：时间复杂度为 O(sqrt(target)),空间复杂度为 O(1)
 * @author dzj
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int target){
        if(target < 0){
            return false;
        }
        int i = 0;
        int j = (int)Math.sqrt(target);
        while(i <= j){
            int powSum = i*i + j*j;
            if(powSum == target){
                return true;
            }else if(powSum > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
