package LeetCode.List;

/**
 * 删除给定链表中的特定节点node，但是不给定链表头结点
 * 要求：时间复杂度O（1）
 * 方法一：将给定节点后一个的内容挪到该节点，删除后一个节点
 *      1、无法删除最后一个节点
 *      2、有时候复制、删除操作比较麻烦，或者是不允许的
 */
public class Problem_17_RemoveNodeWired {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void removeNodeWired(Node node){
        if(node==null){
            return;
        }
        Node next = node.next;
        if(next==null){
            throw new RuntimeException("can not remove last node.");
        }
        node.value = next.value;
        node.next = next.next;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node node = head;
        printLinkedList(head);
        removeNodeWired(node);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        node = head.next;
        printLinkedList(head);
        removeNodeWired(node);
        printLinkedList(head);
    }

}
