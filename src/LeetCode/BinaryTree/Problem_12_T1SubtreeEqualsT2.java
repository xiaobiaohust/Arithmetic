package LeetCode.BinaryTree;

/**
 * 判断t1树是否有与t2树拓扑结构完全相同的子树
 * 思路一：与之前的题目增加了“子树”两个限制，之前是t1跟着t2遍历，
 * 可以增加t2跟着t1遍历，如果两个遍历都满足，则肯定是子树，时间复杂度为O(NxM)
 *
 * 思路二：时间复杂度O(NxM)
 * 1：子树会有一个特别大的一个特点，就是序列化后，子树的所有节点会在一起，
 * 可以将两个树全部序列化，看字符串是否包含，时间复杂度O(N+M)
 * 2：判断一个字符串是否是另一个的子串，可以使用KMP算法，时间复杂度O(N+M)
 *
 */
public class Problem_12_T1SubtreeEqualsT2 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
