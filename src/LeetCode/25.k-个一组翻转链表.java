/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 方法一、递归的思路。
        if(head==null){
            return null;
        }
        if(k==1){
            return head;
        }
        int numNodes = k;
        ListNode cur = head;
        while(cur!=null&&numNodes!=0){
            numNodes--;
            cur=cur.next;
        }
        if(numNodes>0){
            return head;
        }

        ListNode temp = cur;
        ListNode temp1 = null;
        cur =head;
        while(cur!=temp){
            ListNode temp2 = cur.next;
            cur.next=temp1;
            temp1 = cur;
            cur = temp2;
        }
        head.next = reverseKGroup(temp,k);
        return temp1;
    }
}
// @lc code=end

