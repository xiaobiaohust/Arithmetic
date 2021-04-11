/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prehead = new ListNode(-1,head);
        ListNode l1 = prehead;
        ListNode l2 = prehead;
        while(n!=0){
            l2 = l2.next;
            n--;
        }
        while(l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = l1.next.next;
        return prehead.next;

    }
}
// @lc code=end

