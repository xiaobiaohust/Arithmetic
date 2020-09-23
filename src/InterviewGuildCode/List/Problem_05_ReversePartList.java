package InterviewGuildCode.List;


/**
 * 实现反转部分单向链表
 *要求：给定一个单向链表的表头head，以及两个整数from和to，在单向链表中把第from个节点
 * 到第to个节点这一部分进行反转
 * 思路：
 * 1：先判断1<=from<=to<=N是否满足,不满足直接返回原来的头结点
 * 2：先找到from-1个节点fpre,第to-1个节点tpos,fpre反转部分的前一个节点，tpos反转部分的后一个节点
 * 3：如果fpre为null，说明反转部分是包含头结点的，则需要返回新的头结点，也就是反转之前反转部分的
 * 最后一个节点
 */
public class Problem_05_ReversePartList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reversePart(Node head,int from,int to){
        int len = 0;
        Node node1 = head;
        Node fpre = null;
        Node tpos = null;
        while(node1!=null){
            len++;
            fpre = len==from-1?node1:fpre;
            tpos = len==to+1?node1:tpos;
            node1 = node1.next;
        }
        if(from>to||from<1||to>len){
            return head;
        }
        // 根据更不更改头结点，可以从头结点开始或者反转部分第一个头结点开始
        node1 = fpre==null?head:fpre.next;
        Node node2 = node1.next;
        node1.next = tpos;
        Node next = null;
        while(node2!=tpos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fpre!=null){
            fpre.next = node1;
            return head;
        }
        return node1;
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
        Node head = null;
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        head = reversePart(head, 1, 2);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 2, 3);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 1, 3);
        printLinkedList(head);

    }



}
