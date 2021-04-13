/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        // 使用快慢指针找到中间节点，从中间断开变为两个链表，后一个链表进行翻转，在将两个链表进行拼接
        if(head==null||head.next==null||head.next.next==null){
            return;
        }
        ListNode cur1 = head.next;
        ListNode cur2 = head.next.next;
        while(cur2.next!=null&&cur2.next.next!=null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        } 
        cur2 = cur1.next;
        ListNode pre = null;
        while(cur2!=null){
            ListNode next = cur2.next;
            cur2.next = pre;
            pre = cur2;
            cur2 = next;
        }
        cur2= pre;


        cur1.next = null;
        cur1 = head;
        while(cur1!=null&&cur2!=null){
            ListNode nextcur1 = cur1.next;
            ListNode nextcur2 = cur2.next;
            cur1.next = cur2;
            cur2.next = nextcur1;
            cur1 = nextcur1;
            cur2 = nextcur2;
        }

    }
}
// @lc code=end
