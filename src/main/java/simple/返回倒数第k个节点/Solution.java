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
public class Solution {
    public int kthToLast(ListNode head, int k) {
        int len = 1;
        ListNode tempHead = head;
        while (tempHead.next!=null){
            len++;
            tempHead = tempHead.next;
        }
        int i = 1;
        int nodeK;
        while (true){
            if (i == len - k + 1) {
                nodeK = head.val;
                break;
            }
            head = head.next;
            i++;
        }
        return nodeK;
    }


}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
