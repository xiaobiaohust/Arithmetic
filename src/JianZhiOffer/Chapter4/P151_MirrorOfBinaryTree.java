package JianZhiOffer.Chapter4;

import JianZhiOffer.TreeNode;

/**
 * 二叉树的镜像
 */
public class P151_MirrorOfBinaryTree {
    public static void mirror(TreeNode<Integer>root){
        if(root==null){
            return;
        }
        TreeNode<Integer>temp = root.left;
        root.left= root.right;
        root.right =temp;
        mirror(root.left);
        mirror(root.right);

    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(10);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(9);
        root.right.right = new TreeNode<>(11);
        System.out.println(root);
        mirror(root);
        System.out.println(root);
    }
}
