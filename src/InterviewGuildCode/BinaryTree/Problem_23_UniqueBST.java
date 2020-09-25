package InterviewGuildCode.BinaryTree;

/**
 * 统计和生成所有不同的二叉树
 * 给定一个整数N，如果N<1，代表空树结构，否则代表中序遍历的结果为{1,2,3，...
 * N},返回可能的二叉树结构有多少
 * 思路：
 *      中序遍历有序且无重复值，则二叉树必为搜索二叉树，假设以序列的某个
 *      节点作为头结点，左边的序列作为左子树，右边的数作为右子树，
 *      假设num[a]代表a个节点的搜索二叉树有多少种可能，遍历序列，假设
 *      以第i个元素作为头结点，左子树节点个数为i,右子树节点数为N-i,则
 *      以i为头结点的可能结构树：num[i]*num[N-i],在相加就可以
 * 该题有点类似费契那波数列
 * 方法一：使用递归，时间复杂度很高
 * 方法二：使用动态规划，时间复杂度O(N^2)
 */
public class Problem_23_UniqueBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int numTrees(int n){
        if(n<2){
            return 1;
        }
        int[]num = new int[n+1];
        num[0] =1;
        for(int i=1;i<n+1;++i){
            for(int j=1;j<i+1;++j){
                num[i]+=num[j-1]*num[i-j];
            }
        }
        return num[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numTrees(n));

    }
}
