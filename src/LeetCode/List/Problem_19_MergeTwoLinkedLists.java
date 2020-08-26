package LeetCode.List;

/**
 * 合并两个有序链表
 */
public class Problem_19_MergeTwoLinkedLists {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node merge(Node head1,Node head2){
        if(head1==null||head2==null){
            return head1!=null?head1:head2;
        }
        Node head= null;
        Node cur1=head1;
        Node cur2=head2;
        Node tail = null;
        if(head1.value<head2.value){
            head = head1;
            cur1 = head1.next;
        }else{
            head = head2;
            cur2 = head2.next;
        }

        tail = head;
        while (cur1!=null&&cur2!=null){
            if(cur1.value<cur2.value){
                tail.next = cur1;
                tail = cur1;
                cur1 = cur1.next;
            }else{
                tail.next = cur2;
                tail = cur2;
                cur2 = cur2.next;
            }
        }
        tail.next= cur1!=null?cur1:cur2;
        return head;
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

        Node head1 = null;
        Node head2 = null;
        Node head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head2 = null;
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = null;
        head2 = new Node(1);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head2 = new Node(2);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(2);
        head2 = new Node(1);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head1.next = new Node(4);
        head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        head1.next.next.next.next = new Node(9);
        head2 = new Node(0);
        head2.next = new Node(6);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
        head = merge(head1, head2);
        printLinkedList(head);

    }
}
