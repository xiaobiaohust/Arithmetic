package InterviewGuildCode.BinaryTree;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * 判断是否是搜索二叉树
 * 思路1：类似判断一棵树是否是平衡二叉树。需要记录每棵子树是否是搜索二叉树，同时用全局变量记录子树的最大值最小值
 * 思路2：搜索二叉树又叫二叉排序树，可以通过中序遍历，看输出是否有序
 *
 * 判断是否是完全二叉树
 * 思路：我们可以按层打印一棵二叉树，只要一个节点没有左孩子，那么该节点之后的
 * 所有节点都无孩子节点
 */
public class Problem_15_IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST1(Node head) {
        int[] record = new int[2];//0->min,1->max
        return isBST1_(head, record);
    }

    public static boolean isBST1_(Node head, int[] record) {
        if (head == null) {
            record[0] = Integer.MAX_VALUE;
            record[1] = Integer.MIN_VALUE;
            return true;
        }

        boolean flagLeft = isBST1_(head.left, record);
        int lMin = record[0];
        int lMax = record[1];

        boolean flagRight = isBST1_(head.right, record);
        int rMin = record[0];
        int rMax = record[1];

        if (flagLeft && flagRight && head.value > lMax && head.value < rMin) {
            record[0] = Math.min(record[0], head.value);
            record[1] = Math.max(record[1], head.value);
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBST2(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> statck = new Stack<>();
        Node pre = null;
        while (!statck.isEmpty() || head != null) {
            if (head != null) {
                statck.push(head);
                head = head.left;
            } else {
                head = statck.pop();
                if (pre != null && pre.value > head.value) {
                    return false;
                }
                pre = head;
                head = head.right;
            }
        }
        return true;
    }


    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node left = null;
        Node right = null;
        boolean leaf = false;
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                leaf = true;
            }

        }
        return true;
    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
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
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(4);

        printTree(head);
        System.out.println(isBST1(head));
        System.out.println(isBST2(head));
        System.out.println(isCBT(head));

    }
}
