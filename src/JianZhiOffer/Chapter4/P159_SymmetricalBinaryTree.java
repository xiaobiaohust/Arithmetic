package JianZhiOffer.Chapter4;

import JianZhiOffer.TreeNode;

/**
 * 对称二叉树
 * 二叉树的镜像和二叉树一样，则是对称的。
 * 思路一：需要先得到镜像二叉树，然后两个二叉树遍历。放弃。
 * <p>
 * 思路二、
 * 二叉树的先序遍历，以及先跟节点在右子树在左子树的遍历，看结果是否一致。
 * <p>
 * 思路三
 * 左子树的先序遍历，右子树的定义遍历，合并成一个递归里面
 */
public class P159_SymmetricalBinaryTree {
    public static boolean isSymmetrical(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isSymmetrical(root.left, root.right) && isSymmetrical(root.right, root.left);
    }

    public static boolean isSymmetrical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root1.right,root2.left);
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(6);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(7);
        root.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(root));
        //System.out.println(isSymmetrical2(root));
    }
}
