package tv.dzj.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 345. Reverse Vowels of a String (Easy)
 * 题目描述：编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * Given s = "leetcode", return "leotcede".
 * 解题思路：使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
 * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 *
 * 复杂度：时间复杂度为 O(N)：只需要遍历所有元素一次，空间复杂度 O(1)：只需要使用两个额外变量
 * @author dzj
 */
public class ReverseVowels {
    List l = Arrays.asList("a","e","i","o","u","A","E","I","O","U");
    private final HashSet<Character> vowels = new HashSet<Character>(l);

    public String reverseVowels(String s){
        if( s == null ){
            return null;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];
        while(i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)){
                result[i++] = ci;
            } else if (!vowels.contains(cj)){
                result[j--] = cj;
            } else{
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
