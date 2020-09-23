package LeetCode.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的按层打印与zigzag打印
 * 要求：必须输出二叉树节点所在的行数
 */
public class Problem_09_PrintBinaryTreeByLevelAndZigZag {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 按层打印，重点是输出行数，需要记录打印时的行数，引入两个变量last，nLast
     */
    public static void printByLevel(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        int level = 1;
        Node last = head;
        Node nextLast = null;
        System.out.print("Level " + level++ + "：");
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLast = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLast = cur.right;
            }
            if (cur == last && !queue.isEmpty()) {
                System.out.print("\nLevel " + (level++) + "：");
                last = nextLast;
            }
        }
        System.out.println();
    }

    /**
     * zigzag打印，类似按层打印，只是需要记录是从左到右，还是从右到左
     * 1：从左到右打印
     * 从头部pop元素，先left、right放到尾部，保持队列中的元素顺序和按层顺序一样
     * 2：从右到左打印
     * 从尾部pop元素，先right、left放到头部，保持队列中的元素顺序和按层顺序一样
     */
    public static void printByZigZag(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node last = head;
        Node nextLast = null;
        boolean lr = true;
        int level = 1;
        pringLevelAndOrientation(level++, lr);
        Node cur = null;
        while (!queue.isEmpty()) {
            if (lr) {
                cur = queue.pollFirst();
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                    nextLast = nextLast == null ? cur.left : nextLast;
                }
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                    nextLast = nextLast == null ? cur.right : nextLast;
                }
            } else {
                cur = queue.pollLast();
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                    nextLast = nextLast == null ? cur.right : nextLast;
                }
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                    nextLast = nextLast == null ? cur.left : nextLast;
                }
            }
            System.out.print(cur.value + " ");
            if (cur == last && !queue.isEmpty()){
                lr=!lr;
                last = nextLast;
                nextLast = null;
                System.out.println();
                pringLevelAndOrientation(level++,lr);
            }
        }
        System.out.println();
    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void pringLevelAndOrientation(int level, boolean lr) {
        System.out.print("Level " + level + " from ");
        System.out.print(lr ? "left to right: " : "right to left: ");
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.right.left.left = new Node(7);
        head.right.left.right = new Node(8);

        printTree(head);

        System.out.println("===============");
        printByLevel(head);

        System.out.println("===============");
        printByZigZag(head);

    }
}
