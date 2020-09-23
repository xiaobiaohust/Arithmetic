package InterviewGuildCode.List;

import java.util.HashSet;

/**
 * 删除无序单链表中值重复出现的节点
 * 方法一：利用哈希表，时间复杂度O（N）,空间复杂度O（N）
 * 方法二：类似选择排序的过程，时间复杂度O（N^2），空间复杂度O（1）
 */
public class Problem_13_RemoveRepetition {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 方法一：使用哈希表
     */
    public static void removeRep1(Node head){
        if(head==null||head.next==null){
            return ;
        }
        HashSet<Integer>set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur!=null){
            if(set.contains(cur.value)){
                pre.next = cur.next;
            }else{
                set.add(cur.value);
                pre  = cur;
            }
            cur= cur.next;
        }
    }

    /**
     * 方法二：使用类似选择排序
     */
    public static void removeRep2(Node head){
        if(head==null||head.next==null){
            return;
        }

        Node cur = head;
        Node pre = null;
        Node next =null;
        while (cur!=null){
            pre = cur;
            next = cur.next;
            while (next!=null){
                if(cur.value==next.value){
                    pre.next = next.next;
                }else{
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
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
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep1(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep2(head);
        printLinkedList(head);

    }

}
