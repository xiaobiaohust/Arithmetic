/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur= head;
        int tem = 0;
        while(l1!=null||l2!=null||tem>0){
            if(l1!=null){
                tem+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                tem+=l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(tem%10);
            cur= cur.next;
            tem /=10;
    
        }
        return head.next;

    }
}
// @lc code=end

