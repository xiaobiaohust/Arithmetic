package JianZhiOffer.Chapter2;

import JianZhiOffer.ListNode;

import java.util.Stack;


/**
 * 从尾到头打印列表
 */
public class P58_PrintListInReversedOrder {
    //递归版本
    public static void printReversinglyRecursively(ListNode<Integer> head) {
        if (head == null) {
            return;
        }
        printReversinglyRecursively(head.next);
        System.out.println(head.val);
    }

    //非递归版本
    public static void printReversinglyUnRecursively(ListNode<Integer> head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }


    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(3);
        printReversinglyRecursively(head);
        System.out.println();
        printReversinglyUnRecursively(head);
    }
}
