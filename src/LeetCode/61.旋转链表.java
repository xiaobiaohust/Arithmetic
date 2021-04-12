/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        // 根据题目意思，首先需要求出链表长度，以及最后一个节点，最后一个节点连head，形成环
        // 然后求出模，也就是最开始的head需要移动的步数
        if(head==null||head.next==null){
            return head;
        }
        int numNodes=1;
        ListNode cur = head;
        while(cur.next!=null){
            numNodes++;
            cur = cur.next;
        }
        cur.next = head;

        int step = numNodes - k%numNodes;
        while(step!=0){
            step--;
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;


    }
}
// @lc code=end

