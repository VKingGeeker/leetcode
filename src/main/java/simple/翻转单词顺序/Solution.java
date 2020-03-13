package simple.翻转单词顺序;

/**
 * Created with IntelliJ IDEA.
 * Description: XXX
 * User: ww
 * Date: 2020-03-06
 * Time: 17:15
 */
public class Solution {
    public String reverseWords(String s) {
        String str = s.replaceAll("\\s{1,}", " ");
        if (str.startsWith(" ")){
            str = str.substring(1, str.length());
        }
        if (str.endsWith(" ")){
            str = str.substring(0, str.length() -1);
        }

        String[] split = str.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = split.length -1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return String.valueOf(sb);
    }
}
