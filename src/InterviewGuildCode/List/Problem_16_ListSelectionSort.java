package InterviewGuildCode.List;

/**
 * 单链表的选择排序
 * 要求：空间复杂度O（1）,只能选择几个有限变量，所有只能在原始链表中进行排序
 * 代码乱七八糟的，需要整理和注释
 */
public class Problem_16_ListSelectionSort {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node selectionSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = head;
        while (cur!= null) {
            smallPre = getSmallestPreNode(cur);
            if(smallPre!=null){
                //最小值不是第一个元素
                small = smallPre.next;
                smallPre.next = small.next;
            }else{
                small = cur;
                cur = cur.next;
            }

            if(tail==null){
                head = small;
            }else{
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }
    //找到链表中的最小值，
    public static Node getSmallestPreNode(Node head){
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur!=null){
            if(cur.value<small.value){
                smallPre = pre;
                small =cur;
            }
            pre = cur;
            cur= cur.next;
        }
        return smallPre;
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
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

    }


}
