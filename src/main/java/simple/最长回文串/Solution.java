package simple.最长回文串;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * User: ww
 * Date: 2020-03-19
 * Time: 16:37
 */
public class Solution {
    public static int longestPalindrome(String s) {
        int len = 0;
        int singleLen = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            String temp = String.valueOf(sb.charAt(i));
            //如果第一个和最后一个的索引不同，就说明有两个一样的
            if (i != sb.lastIndexOf(temp)) {
                len += 2;
                sb.deleteCharAt(i);
                sb.deleteCharAt(sb.lastIndexOf(temp));
                i--;
            } else {
                singleLen = 1;
            }
        }
        return len + singleLen;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccccdd"));
//        int[] ints = new int[128];
//        System.out.println(ints[0]);
    }
}
