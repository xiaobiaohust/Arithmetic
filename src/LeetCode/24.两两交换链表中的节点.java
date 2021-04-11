/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {

        // 方法一、使用遍历，先穿再排后判断
        
        // if (head==null){
        //     return null;
        // }
        // ListNode prehead =new ListNode(-1,head);
        // ListNode cur = prehead;
        // ListNode temp1 = null;
        // ListNode temp2 = null;
        // ListNode temp3 = null;
        // while(cur.next!=null&&cur.next.next!=null){
        //     temp1 = cur.next;
        //     temp2 = cur.next.next;
        //     temp3 = cur.next.next.next;
        //     cur.next = temp2;
        //     cur.next.next = temp1;
        //     cur.next.next.next = temp3;
        //     cur = cur.next.next;
        // }
        // return prehead.next;

        //方法二、使用递归
        if ((head == null)||(head.next == null))
        return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
       

    }
}
// @lc code=end

