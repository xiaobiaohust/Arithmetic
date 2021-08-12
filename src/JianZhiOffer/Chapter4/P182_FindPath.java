package JianZhiOffer.Chapter4;

import JianZhiOffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * 递归
 * 假设期望值为K,跟节点值为val,看左右子树是否存在路径的和的值为K-val
 */
public class P182_FindPath {
    public static void findpath(TreeNode<Integer> root, int expectValue) {
        if (root == null) return;
        List<Integer> path = new ArrayList<>();
        findpath(root, path, expectValue);
    }

    public static void findpath(TreeNode<Integer> root, List<Integer> path, int expectValue) {
        path.add(root.val);
        if (root.left != null) {
            findpath(root.left, path, expectValue - root.val);
        }
        if (root.right != null) {
            findpath(root.right, path, expectValue - root.val);
        }
        if (root.left == null && root.right == null && expectValue == root.val) {
            System.out.println(path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(5);
        root.right = new TreeNode<Integer>(12);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(7);
        findpath(root, 22);
    }

}
