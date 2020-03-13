package simple.longestpalindromicsubstring;

/**
 * Created with IntelliJ IDEA.
 * Description: XXX
 * User: ww
 * Date: 2019-04-25
 * Time: 14:41
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
    public static String longestPalindrome(String s) {
        int maxChars = 0;
        String maxStr = "";
        for (char ch:s.toCharArray()) {
            if (s.lastIndexOf(ch) - s.indexOf(ch)>=maxChars){
                maxChars = s.lastIndexOf(ch) - s.indexOf(ch);
                maxStr = s.substring(s.indexOf(ch), s.lastIndexOf(ch)+1);
            }
        }
        return maxStr;
    }
}
