/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 方法一、如果空间复杂度要求O(1)，,可以把两个链表反转，然后从第一个元素进行比较，直到不相等，找到相交节点
        // 方法二、对空间复杂度无要求，可以使用栈，也可以使得链表倒过来，在进行比较
        // 方法三、长的链表先遍历若干步，然后长短链表一起遍历，找到相交节点
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int num1 = 0;
        int num2 = 0;
        while (cur1 != null) {
            num1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            num2++;
            cur2 = cur2.next;
        }
        cur1 = headA;
        cur2 = headB;
        if (num1 > num2) {
            while (num1 > num2) {
                num1--;
                cur1 = cur1.next;
            }
        } else {
            while (num1 < num2) {
                num2--;
                cur2 = cur2.next;
            }
        }
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

    }
}
// @lc code=end
