package simple.整数的各位积和之差;

import sun.security.util.Length;

/**
 * Created with IntelliJ IDEA.
 * Description: 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 *
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 10^5
 *
 * User: ww
 * Date: 2020-03-10
 * Time: 17:07
 */
public class Solution {
    //蠢办法
    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        int len = String.valueOf(n).length();
        for (int i = len - 1 ; i >= 0; i--) {
            sum += (int)(n / Math.pow(10,i));
            product *= (int)(n / Math.pow(10,i));
            n = (int) (n % Math.pow(10,i));
        }
        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));
    }
}
