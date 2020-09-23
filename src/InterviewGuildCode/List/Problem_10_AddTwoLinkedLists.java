package InterviewGuildCode.List;

import java.util.Stack;

/**
 * 两个链表生成相加链表
 * 方法一：使用栈结构
 * 方法二：利用链表的逆序求解
 */
public class Problem_10_AddTwoLinkedLists {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 方法一：使用栈结构
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node addLists1(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Node cur = head1;
        while (cur != null) {
            s1.push(cur.value);
            cur = cur.next;
        }
        cur = head2;
        while (cur != null) {
            s2.push(cur.value);
            cur = cur.next;
        }

        int n1 = 0;
        int n2 = 0;
        int ca = 0;
        int n = 0;
        Node pre = null;
        Node node = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            ca = n / 10;
            node = new Node(n % 10);
            node.next = pre;
            pre = node;
        }
        if (ca == 1) {
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    public static Node addLists2(Node head1, Node head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int ca = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        Node pre = null;
        Node node = null;
        while (cur1 != null || cur2 != null) {
            n1 = cur1 != null ? cur1.value : 0;
            n2 = cur2 != null ? cur2.value : 0;
            n = n1 + n2 + ca;
            ca = n / 10;
            node = new Node(n % 10);
            node.next = pre;
            pre = node;
            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
        }
        if(ca==1){
            node = new Node(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(8);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node head2 = new Node(1);
        head2.next = new Node(9);

        printLinkedList(head1);
        printLinkedList(head2);
        printLinkedList(addLists1(head1, head2));
        printLinkedList(addLists2(head1, head2));

    }
}
