/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode prehead = new ListNode(-1,head);
        ListNode cur1 = prehead;
        ListNode cur2 = prehead;
        while(cur2.next!=null&&cur2.next.next!=null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if(cur1==cur2){
                return true;
            }
        }
        return false;
        
    }
}
// @lc code=end

