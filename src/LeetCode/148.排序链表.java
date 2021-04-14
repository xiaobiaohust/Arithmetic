/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) { 
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while(cur2.next!=null&&cur2.next.next!=null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        cur2 = cur1.next;
        cur1.next = null;
        cur1 = sortList(head);
        cur2 = sortList(cur2);
        return merge(cur1, cur2);

    }
    public ListNode merge(ListNode cur1,ListNode cur2){
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                cur.next = cur1;
                cur= cur.next;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if(cur1!=null){
            cur.next = cur1;
        }
        if(cur2!=null){
            cur.next = cur2;
        }
        return prehead.next;
    }
}
// @lc code=end

