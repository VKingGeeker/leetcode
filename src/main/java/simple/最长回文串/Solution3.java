package simple.最长回文串;

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
public class Solution3 {
    public static int longestPalindrome(String s) {
        //创建一个数组，存放每个字符的出现的个数，索引就是每个字符对应的ASCII码值,128为a-Z的最大范围
        int[] countOfchars = new int[128];
        for (char ch : s.toCharArray()) {
            //该字符对应的个数+1
            countOfchars[ch]++;
        }
        //用来记录个数为奇数的字符数
        int single = 0;
        for (int count : countOfchars) {
            //如果个数为奇数,就算到奇数字符长度里
            single += count % 2;
        }
        //1.如果没有奇数字符,说明可以组成s长度的回文
        //2.如果有奇数字符,就减去奇数个数,再加一
        return single == 0 ? s.length() : s.length() - single + 1;

    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccccdd"));

    }
}
