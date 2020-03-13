package simple.翻转单词顺序;

/**
 * Created with IntelliJ IDEA.
 * Description: XXX
 * User: ww
 * Date: 2020-03-06
 * Time: 17:15
 */
public class Solution2 {
    public String reverseWords(String s) {
        StringBuffer space = new StringBuffer();

        char[] chars = s.toCharArray();
        boolean isSpace = false;
        for (int i = 0; i < chars.length ; i++) {
            if (i < chars.length -1  &&chars[i] == ' ' && chars[i + 1] == ' ') {
                isSpace = true;
            }

            if (i < chars.length -1  && chars[i+1] != ' '){
                isSpace = false;
            }
            if (!isSpace){
                space.append(chars[i]);
            }
        }
        String str = String.valueOf(space);
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

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = solution2.reverseWords("  hello world!  ");
        System.out.println(s);
    }
}
