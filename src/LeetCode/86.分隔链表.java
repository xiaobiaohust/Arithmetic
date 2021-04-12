/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 =  new ListNode(-1);
        ListNode cur = head;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while(cur!=null){
            if(cur.val<x){
                cur1.next=cur;
                cur1 = cur1.next;
                cur = cur.next;

            }else{
                cur2.next=cur;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }
        cur1.next = head2.next;
        cur2.next = null;
        return head1.next;
    }
}
// @lc code=end

