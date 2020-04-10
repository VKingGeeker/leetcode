package simple.汉明距离;

/**
 * Created with IntelliJ IDEA.
 * Description: XXX
 * User: ww
 * Date: 2020-03-16
 * Time: 15:35
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

    public static int hammingDistance(int x, int y) {

        StringBuilder xBin = new StringBuilder(Integer.toBinaryString(x));
        StringBuilder yBin = new StringBuilder(Integer.toBinaryString(y));

        int len = Math.abs(xBin.length() - yBin.length());
        int count = 0;
        //左边补零
        for (int i = 0; i < len; i++) {
            if (xBin.length() > yBin.length()) {
                yBin.insert(0, "0");
            }else{
                xBin.insert(0, "0");
            }
        }

        for (int i = 0; i < xBin.length(); i++) {
            if (xBin.charAt(i) != yBin.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
