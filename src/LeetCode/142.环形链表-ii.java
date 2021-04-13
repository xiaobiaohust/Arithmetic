/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        ListNode cur1 = head.next;
        ListNode cur2 = head.next.next;
        while(cur1!=cur2){
            if(cur2.next==null||cur2.next.next==null){
                return null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        cur2 = head;
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
        
        
    }
}
// @lc code=end

