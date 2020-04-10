package simple.按既定顺序创建目标数组;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: XXX
 * User: ww
 * Date: 2020-04-10
 * Time: 10:03
 */
public class Solution {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            if (i > index[i]) {
                for (int j = target.length - 1; j > index[i]; j--) {
                    target[j] = target[j - 1];
                }
            }
            target[index[i]] = nums[i];
        }
        return target;

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
    }
}
