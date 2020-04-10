package simple.字符串的最大公因子;

/**
 * Created with IntelliJ IDEA.
 * Description: 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * <p>
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * <p>
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * 提示：
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * <p>
 * User: ww
 * Date: 2020-03-13
 * Time: 10:34
 */
public class Solution2 {
    public static String gcdOfStrings(String str1, String str2) {
        //更相减损术 or 辗转相除法
        //如果两个数有最大公因数  则a+b = b+a
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }else{
            //递归结束条件 ： 切割到最后两数长度相等,则该数就是最大公因数
            int len1 = str1.length();
            int len2 = str2.length();
            if (len1==(len2)) {
                return str1;
            }else{
                //将多的数切掉相同的部分
                if (len2>len1) {
                    str2 = str2.substring(len1, len2);
                    return gcdOfStrings(str1, str2);
                }else{
                    str1 = str1.substring(len2, len1);
                    return gcdOfStrings(str1, str2);
                }
            }
        }
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(gcdOfStrings("CXTXNCXTXNCXTXNCXTXNCXTXN",
//                "CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN"
//        ));
        System.out.println(gcdOfStrings("ABCABC",
                "ABCABCABCABCABC"
        ));
        long during = System.currentTimeMillis() - start;
        System.out.println(during);
    }
}
