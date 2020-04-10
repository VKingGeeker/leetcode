package simple.返回倒数第k个节点;

/**
 * Created with IntelliJ IDEA.
 * Description: 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * User: ww
 * Date: 2020-03-13
 * Time: 16:48
 */
public class Solution2 {
    public int kthToLast(ListNode head, int k) {
        //快慢指针法
        //快指针
        ListNode fastPoint = head;
        //慢指针
        ListNode slowPoint = head;
        //快指针先走k步
        while(k > 0){
            fastPoint = fastPoint.next;
            k--;
        }
        //快慢指针一起走，当快指针顶到头的时候,慢指针的值就是要求的值
        while (fastPoint!=null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }
        return slowPoint.val;
    }


}


