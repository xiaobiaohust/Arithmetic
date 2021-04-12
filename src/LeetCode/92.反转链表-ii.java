/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prehead = new ListNode(-1,head);
        ListNode cur = prehead;
        ListNode pre = null;
        ListNode node1 = null;
        int index = 0;
        while(index<=right){
            if(index==left-1){
                node1 = cur;
            }
            if(index>left &&index<=right){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;

            }else{
                pre = cur;
                cur = cur.next;
            }
            index++;
        }
        node1.next.next = cur;
        node1.next = pre;
        return prehead.next;

    }
}
// @lc code=end
