/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        boolean flag = true;
        if(head.next==null){
            return true;
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while(cur2.next!=null&&cur2.next.next!=null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        ListNode tail1= cur1;
        ListNode head2 = cur1.next;
        cur1.next = null;
        
        // 将后半部分链表反转
        ListNode pre=null;
        ListNode next = null;
        cur2=head2;
        while(cur2!=null){
            next = cur2.next;
            cur2.next = pre;
            pre = cur2;
            cur2 = next;
        }

        // 前半部分链表和后半部分链表进行比较
        cur1 = head;
        cur2 = pre;
        while(cur1!=null&&cur2!=null){
            if(cur1.val!=cur2.val){
                flag = false;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        //后半部分链表进行还原
        cur2 = pre;
        pre = null;
        next = null;
        while(cur2!=null){
            next = cur2.next;
            cur2.next = pre;
            pre = cur2;
            cur2 = next;
        }
        tail1.next = pre;

        return flag;


    }
}
// @lc code=end

