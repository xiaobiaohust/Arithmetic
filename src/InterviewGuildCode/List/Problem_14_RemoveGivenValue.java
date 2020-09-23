package InterviewGuildCode.List;

import java.util.Stack;

/**
 * 在单链表中删除指定值的节点
 * 方法一：利用栈或者容器收集不等于指定值的节点，在将节点连接。收集复杂度O（N）
 * 空间复杂度O（N）
 * 方法二：直接调整，时间复杂度O（N），空间复杂度O（1）
 *
 */
public class Problem_14_RemoveGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeValue(Node head,int num){
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            if(head.value!=num){
                break;
            }
            head = head.next;
        }
        Node pre= head;
        Node cur = head;
        while (cur!=null){
            if(cur.value==num){
                pre.next = cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
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
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(1);
        head = removeValue(head, 1);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(1);
        head = removeValue(head, 1);
        printLinkedList(head);

    }


}
