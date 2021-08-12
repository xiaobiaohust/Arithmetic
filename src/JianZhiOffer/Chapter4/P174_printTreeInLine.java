package JianZhiOffer.Chapter4;

import JianZhiOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树  详情见面试指南。本地使用了一种新的方式
 */
public class P174_printTreeInLine {
    public static void printTreeInLine(TreeNode<Integer> root){
        if(root==null)
            return;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode<Integer> temp;
        while (!queue.isEmpty()){
            for(int size=queue.size();size>0;size--){
                temp = queue.poll();
                System.out.print(temp.val);
                System.out.print("\t");
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        printTreeInLine(root);
    }
}
