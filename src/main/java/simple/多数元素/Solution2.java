package simple.多数元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * User: ww
 * Date: 2020-03-13
 * Time: 15:03
 */
public class Solution2 {
    //从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
    public static int majorityElement(int[] nums) {
        int multiNum = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (multiNum == nums[i + 1]) {
                count ++;
            } else {
                count --;
            }
            if (count == 0) {
                multiNum = nums[i + 1];
                count = 1;
            }
        }
        return multiNum;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

}
