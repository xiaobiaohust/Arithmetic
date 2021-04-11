package InterviewGuildCode.BinaryTree;

import java.util.Stack;

/**
 * 调整搜索二叉树中两个错误的节点
 * 一棵二叉树原本是搜索二叉树，但是两个节点调换了位置，使得这棵二叉树不再是
 * 搜索二叉树，请找到这两个节点并返回
 * 思路1：寻找二叉树的最大二叉搜索数的最大拓扑结构，每个节点从跟节点开始分流，
 * 如果不能到达原始位置，则该元素是其中的一个元素
 * 思路2：
 *搜索二叉树中序遍历结果会是升序，可以通过判断降序的地方在哪，
 * 以有两处地方降序，也可能只有一处地方降序（两个元素相邻）
 *
 */
public class Problem_10_RecoverBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node[] getTwoErrNodes(Node head) {
        Node[] errs = new Node[2];
        if (head == null) {
            return errs;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && pre.value > cur.value) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = cur;
                }
                pre = head;
                head = head.right;
            }


        }
        return errs;
    }


}
