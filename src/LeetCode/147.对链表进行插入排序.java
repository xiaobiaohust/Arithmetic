/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode helpNode = new ListNode(-1);
        ListNode pre = helpNode;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = helpNode;
            cur = next;

        }
        return helpNode.next;

    }
}
// @lc code=end
