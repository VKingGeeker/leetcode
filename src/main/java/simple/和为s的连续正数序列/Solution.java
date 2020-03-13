package simple.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */


class Solution {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> arrayList = new ArrayList<>();

        //1.如果当前位*2>=9 则循环结束即循环限定条件为 <= (target+1)/2
        //2.如果当前位与之后的连续为和为9  加到数组a中
        //3.如果连续和>9  则进行下一位

        int index = 0;
        for (int i = 1; i <= (target + 1) / 2; i++) {
            List<Integer> listInner = new ArrayList<>();
            int sum = i;
            listInner.add(i);
            for (int j = i+1; j <= (target + 1) / 2; j++) {
                listInner.add(j);
                sum += j;
                if (sum == target) {
                    arrayList.add(listInner);
                    break;
                }else if (sum > target){
                    break;
                }
            }
        }

        int[][] all = new int[arrayList.size()][];

        for (int i = 0; i < all.length; i++) {
            int[] inner = new int[arrayList.get(i).size()];
            for (int j = 0; j < inner.length; j++) {
                inner[j] = arrayList.get(i).get(j);
            }
            all[i] = inner;
        }

        return all;
    }
}
