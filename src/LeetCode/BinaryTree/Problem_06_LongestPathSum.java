package LeetCode.BinaryTree;

import java.util.HashMap;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 * 给定一棵二叉树的头结点head和一个整数sum，路径是指从某个节点往下，每次最多选择
 * 一个孩子节点或者不选择所形成的的节点链
 * <p>
 * 要求：时间复杂度O(N)，额外空间复杂度O(h)
 * 思路：
 * 1：类似于求未排序数组中累加和为规定值的最长子数组长度，从跟节点到每个
 * 叶节点，可以看作一个一个数组。
 * 2：先序遍历，可以访问近视认为访问每一条跟节点到叶节点的路径，特殊处理
 * 是在退回到父节点之前，需要将一些状态恢复。
 */
public class Problem_06_LongestPathSum {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int getMaxLength(Node head, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        return preOrder(head, sum, 0, 1, 0, map);
    }

    /**
     * 表示以head为跟节点的子树的最大长度
     * @param head
     * @param sum
     * @param preSum
     * @param level
     * @param maxLen
     * @param map
     * @return
     */
    public static int preOrder(Node head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> map) {
        if (head == null) {
            return maxLen;
        }
        //从跟节点开始，以当前节点结尾的和，并且更新map
        int curSum = preSum + head.value;
        if (!map.containsKey(curSum)) {
            map.put(curSum, level);
        }
        if (map.containsKey(curSum - sum)) {
            maxLen = Math.max(maxLen, level - map.get(curSum - sum));
        }
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, map);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, map);

        //会到父节点之前，如果当前节点更新了map，需要删除
        if(level==map.get(curSum)){
            map.remove(curSum);
        }
        return maxLen;
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
        Node head = new Node(-3);
        head.left = new Node(3);
        head.right = new Node(-9);
        head.left.left = new Node(1);
        head.left.right = new Node(0);
        head.left.right.left = new Node(1);
        head.left.right.right = new Node(6);
        head.right.left = new Node(2);
        head.right.right = new Node(1);
        printTree(head);
        System.out.println(getMaxLength(head, 6));
        System.out.println(getMaxLength(head, -9));

    }

}
