package simple.二进制链表转整数;

/**
 * Created with IntelliJ IDEA.
 * Description: 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)

 * 示例 2：

 * 输入：head = [0]
 * 输出：0

 * 示例 3：

 * 输入：head = [1]
 * 输出：1

 * 示例 4：

 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880

 * 示例 5：

 * 输入：head = [0,0]
 * 输出：0

 * 提示：

 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。

 * User: ww
 * Date: 2020-03-10
 * Time: 17:56
 */
public class Solution {
    public static int getDecimalValue(ListNode head) {
        //第一步求链表长度  由于是从左到右  所以只能遍历
        int len = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            len += 1;
            tempHead = tempHead.next;
        }
        int sum = 0;
        //知道长度后就可以遍历链表,用二转十进制的方法转换
        for (int i = len - 1; i >= 0; i--) {
            if (head.val == 1) {
                sum += Math.pow(2, i);
            }
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
