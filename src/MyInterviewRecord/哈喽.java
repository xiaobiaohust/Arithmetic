package MyInterviewRecord;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 */
public class 哈喽 {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node fun(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;

        while (cur != null) {
            if (cur.value != pre.value) {

                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 5,5};
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; ++i) {
            Node node = new Node(arr[i]);
            cur.next = node;
            cur = cur.next;
        }
        Node res = fun(head);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}
