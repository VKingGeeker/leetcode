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
public class Solution {
    public static String gcdOfStrings(String str1, String str2) {

        //遍历

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        StringBuilder temp = new StringBuilder();
        StringBuilder maxSon = new StringBuilder();
        int len = str1.length() < str2.length() ? str1.length() : str2.length();
        for (int i = 0; i < len; i++) {
            temp.append(chars1[i]);
            if ((i == len - 1 || chars1[i + 1] == chars1[0]   ) && chars1[i] == chars2[i]) {
                String[] split1 = str1.split(String.valueOf(temp), -1);
                String[] split2 = str2.split(String.valueOf(temp), -1);
                if (split1.length != 1 && split2.length != 1) {
                    boolean flag1 = true;
                    boolean flag2 = true;
                    for (int j = 0; j < split1.length - 1; j++) {
                        if (!split1[j].equals(split1[j + 1])) {
                            flag1 = false;
                            break;
                        }
                    }
                    for (int j = 0; j < split2.length - 1; j++) {
                        if ( !split2[j].equals(split2[j + 1])) {
                            flag2 = false;
                            break;
                        }
                    }
                    if (flag1 && flag2) {
                        maxSon.replace(0, maxSon.length(), String.valueOf(temp));
                    }
                }

            }


        }
        return String.valueOf(maxSon);
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
