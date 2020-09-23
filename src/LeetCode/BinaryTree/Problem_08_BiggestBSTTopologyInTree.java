package LeetCode.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 * 给定一棵二叉树的头结点，已知所有节点的值都不一样，返回其中最大的且符合
 * 搜索二叉树条件的最大拓扑结构的大小
 */
public class Problem_08_BiggestBSTTopologyInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一：时间复杂度O(N^2)
     * 思路：遍历求出以每个节点为跟节点的最大符合条件的拓扑结构，假设以h节点
     * 为跟节点，先判断跟节点的孩子节点，根据大小每次向左或者右移动，最后能
     * 到达原来节点的位置上，说明该节点是拓扑结构的一部分
     * @param head
     * @return
     */

    // 求出以head为跟节点的子树的最大拓扑结构，遍历二叉树一般递归最简单
    public static int bstTopoSize1(Node head) {
        if (head == null) {
            return 0;
        }
        //判断以head为跟节点的最大拓扑结构
        int max = maxTopo(head, head);
        max = Math.max(max, bstTopoSize1(head.left));
        max = Math.max(max, bstTopoSize1(head.left));
        return max;
    }

    /**
     * 在以head为跟节点的最大拓扑结构中，以node为根节点的最大子拓扑结构
     *
     * @param head
     * @param node
     * @return
     */
    public static int maxTopo(Node head, Node node) {
        if (head != null && node != null && isBSTNode(head, node)) {
            return maxTopo(head, node.left) + maxTopo(head, node.right) + 1;
        }
        return 0;
    }

    /**
     * 判断node节点是否是以head为跟节点的最大拓扑结构的一部分
     *
     * @param head
     * @param node
     * @return
     */
    public static boolean isBSTNode(Node head, Node node) {
        if (head == null) {
            return false;
        }
        if (head == node) {
            return true;
        }
        return isBSTNode(head.value > node.value ? head.left : head.right, node);
    }

    /**
     * 先序遍历，会有很多重复的，使用map存起来，使用后序遍历，能够实现
     * 时间复杂度O(NlogN)
     *
     */
    public static class Record {
        public int l;
        public int r;

        public Record(int left, int right) {
            this.l = left;
            this.r = right;
        }
    }
    public static int bstTopoSize2(Node head) {
        Map<Node, Record> map = new HashMap<Node, Record>();
        return posOrder(head, map);
    }
    public static int posOrder(Node h, Map<Node, Record> map) {
        if (h == null) {
            return 0;
        }
        int ls = posOrder(h.left, map);
        int rs = posOrder(h.right, map);
        modifyMap(h.left, h.value, map, true);
        modifyMap(h.right, h.value, map, false);
        Record lr = map.get(h.left);
        Record rr = map.get(h.right);
        int lbst = lr == null ? 0 : lr.l + lr.r + 1;
        int rbst = rr == null ? 0 : rr.l + rr.r + 1;
        map.put(h, new Record(lbst, rbst));
        return Math.max(lbst + rbst + 1, Math.max(ls, rs));
    }

    public static int modifyMap(Node n, int v, Map<Node, Record> m, boolean s) {
        if (n == null || (!m.containsKey(n))) {
            return 0;
        }
        Record r = m.get(n);
        if ((s && n.value > v) || ((!s) && n.value < v)) {
            m.remove(n);
            return r.l + r.r + 1;
        } else {
            int minus = modifyMap(s ? n.right : n.left, v, m, s);
            if (s) {
                r.r = r.r - minus;
            } else {
                r.l = r.l - minus;
            }
            m.put(n, r);
            return minus;
        }
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
        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);
        printTree(head);

        System.out.println(bstTopoSize1(head));
        System.out.println(bstTopoSize2(head));

    }

}
