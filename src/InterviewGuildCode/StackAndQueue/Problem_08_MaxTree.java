package InterviewGuildCode.StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * 设计一个数组的最大树
 *要求：
 * 数组没有重复元素；maxtree是一棵二叉树，数组的每一个值对应一个二叉树节点；每一棵子树最大值在跟节点
 * 数组长度为N，要求时间复杂度为O(N),额外空间复杂度为O(N)
 *
 * 思路1：最大堆的建立过程时间复杂度O(NlogN)
 *
 * 思路2：最大树的答案不是唯一的，存在多个满足条件的最大树。按照下面规则可以
 * 得到一颗二叉树，而且父节点比孩子节点大，满足要求。
 *  1：每一个数的父节点是它左边第一个比它大的数和右边第一个比它大的数中，较小的那个
 *  2：一个数左边没有比它大的数，右边也没有比它大的数，则该数是跟节点
 */
public class Problem_08_MaxTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i != arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<Node>();
        HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
        HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
        //得到每个节点左边第一个比它大的数，使用的是栈的思想，类似求滑动窗口
        //最大数组一样。每个节点左边第一个比它大的数，一定是在栈中前面一个节点
        //每个节点都会入栈出栈一次，在出栈的时候记录使用map记录对应的值
        // 时间复杂度O(N)
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        //得到每个节点右边第一个比它大的数，时间复杂度O(N)
        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }

        //遍历每个节点，找到每个节点对应的父节点，最后没有父节点的就是跟节点
        Node head = null;
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

    public static void printPreOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }

    public static void printInOrder(Node head) {
        if (head == null) {
            return;
        }
        printPreOrder(head.left);
        System.out.print(head.value + " ");
        printPreOrder(head.right);
    }

    public static void main(String[] args) {
        int[] uniqueArr = { 3, 4, 5, 1, 2 };
        Node head = getMaxTree(uniqueArr);
        printPreOrder(head);
        System.out.println();
        printInOrder(head);

    }

}
