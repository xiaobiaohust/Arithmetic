package JianZhiOffer.Chapter2;

import JianZhiOffer.TreeNode;

/**
 * 重建二叉树
 * 前序+中序，后序+中序可以完成重建，而前序+后序无法完成重建
 * 使用递归很好解决，可以使用map存储中序的每个值所在的位置，要不然需要多次遍历
 */
public class P62_ConstructBinaryTree {
    public static TreeNode construct(int[]preorder,int []inorder){
        if(preorder==null||inorder==null||preorder.length==0||preorder.length!=inorder.length){
            return null;
        }

    }
}
