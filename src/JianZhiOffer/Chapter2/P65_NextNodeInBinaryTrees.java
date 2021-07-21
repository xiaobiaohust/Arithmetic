package JianZhiOffer.Chapter2;

/**
 * 二叉树的下一个节点
 * 此二叉树不仅有两个孩子节点指针，还有一个父节点指针，下一个节点指的是中序遍历的下一个节点
 *
 * 思路：如果没有父节点，直接中序遍历一遍就可找出
 *      有父节点的话，那就更好找了
 *      看该节点是否有右子树，有右子树，则是右子树的最左边的那个节点
 *      没有右子树，是父节点的左子树，则下一个节点就是父子树
 *      没有右子树，是父节点的右子树，则一直向上回退到父节点，继续判断
 */
public class P65_NextNodeInBinaryTrees {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode father;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.father = null;
        }
    }

}
