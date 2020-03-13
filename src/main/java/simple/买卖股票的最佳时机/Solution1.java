package simple.买卖股票的最佳时机;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * * User: ww
 * Date: 2020-03-09
 * Time: 14:29
 */
public class Solution1 {
    public static void main(String[] args) {

//        int[] prices = {2, 7, 1, 4};
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {2, 4, 1};
        int[] prices = {2,1,2,1,0,1,2};
//        int[] prices = {10,8,6,5,2};
        //最小的买入金额
        int minBuy = 999999;
        //最大利润
        int maxProfit = 0;
        //每次遍历看两个数,i和i+1的数,i用来和最小买入金额比较,如果更小就替换买入金额
        //i+1用来和最小买入金额做差值算利润,然后和最大利润比较,如果比最大利润大就替换最大利润
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            }
            if (prices[i + 1] - minBuy > maxProfit) {
                maxProfit = prices[i + 1] - minBuy;
            }
        }
        System.out.println(maxProfit);
    }
}
