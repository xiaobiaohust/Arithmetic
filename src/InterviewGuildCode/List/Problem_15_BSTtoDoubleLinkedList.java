package InterviewGuildCode.List;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转换成双向链表
 * 方法一：用队列收集二叉树中序遍历结果的方法，时间复杂度O（N），空间复杂度（N）
 * 方法二：利用递归函数，时间复杂度O（N），空间复杂度O（log N）
 */
public class Problem_15_BSTtoDoubleLinkedList {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 方法一：使用容器
     */
    public static Node convert1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        inorderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        Node pre = head;
        head.left = null;
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;

    }

    public static void inorderToQueue(Node head, Queue<Node> queue) {
        if (head == null) {
            return;
        }
        inorderToQueue(head.left, queue);
        queue.add(head);
        inorderToQueue(head.right, queue);
    }

    /**
     * 使用递归
     * @param head
     * @return
     */
    public static Node convert2(Node head){
        if(head==null){
            return head;
        }
        Node last = process(head);
        head  = last.right;
        last.right = null;
        return head;
    }

    public static Node process(Node head){
        if(head==null){
            return head;
        }
        Node leftE = process(head.left);
        Node rightE = process(head.right);
        Node lefts = leftE!=null?leftE.right:null;
        Node rights = rightE!=null?rightE.right:null;
        if(leftE!=null&&rightE!=null){
            leftE.right = head;
            head.left = leftE;
            head.right = rights;
            rights.left = head;
            rightE.right = lefts;
            return rightE;
        }
        else if(leftE!=null){
            leftE.right = head;
            head.left = leftE;
            head.right = lefts;
            return head;
        }else if(rightE!=null){
            head.right = rights;
            rights.left = head;
            rightE.right = head;
            return rightE;
        }else{
            head.right = head;
            return head;
        }
    }




    public static void printBSTInOrder(Node head){
        System.out.print("BST in-order: ");
        if (head != null) {
            inOrderPrint(head);
        }
        System.out.println();
    }

    public static void inOrderPrint(Node head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }
    public static void printDoubleLinkedList(Node head) {
        System.out.print("Double Linked List: ");
        Node end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = convert1(head);
        printDoubleLinkedList(head);

        head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = convert2(head);
        printDoubleLinkedList(head);

    }

}
