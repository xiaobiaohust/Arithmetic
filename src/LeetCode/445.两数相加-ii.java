import java.util.Stack;

import org.graalvm.compiler.nodes.java.NewMultiArrayNode;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
        Stack<ListNode>stack1 = new Stack<>();
        Stack<ListNode>stack2 = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newhead = new ListNode(-1);
        ListNode prehead = newhead;
        while(cur1!=null){
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        while(cur2!=null){
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        int carry = 0;
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            cur1 = stack1.pop();
            cur2 = stack2.pop();
            prehead.next = new ListNode((cur1.val+cur2.val+carry)%10);
            prehead = prehead.next;
            carry = (cur1.val+cur2.val+carry)/10;
        }
        while(!stack1.isEmpty()){
            cur1 = stack1.pop();
            prehead.next = new ListNode((cur1.val+carry)%10);
            prehead = prehead.next;
            carry = (cur1.val+carry)/10;
        }
        while(!stack2.isEmpty()){
            cur2 = stack2.pop();
            prehead.next = new ListNode((cur2.val+carry)%10);
            prehead = prehead.next;
            carry = (cur2.val+carry)/10;
        }
        if(carry>0){
            prehead.next= new ListNode(carry);
        }
        // 翻转新生成的链表
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = newhead.next;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
// @lc code=end

