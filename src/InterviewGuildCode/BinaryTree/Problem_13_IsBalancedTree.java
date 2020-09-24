package InterviewGuildCode.BinaryTree;

/**
 * 判断二叉树是否为平衡二叉树
 * 二叉树平衡性质：要么是一棵空树，要么一个节点的左右子树的高度差的
 * 绝对值不超过1
 * 要求：时间复杂度为O(N)
 * 思路：需要判断左子树是否为平衡二叉树以及左子树的高度，在判断右子树是否
 * 为平衡二叉树以及右子树的高度，在综合左右子树的信息。所以整体过程为
 * 二叉树的后序遍历
 */
public class Problem_13_IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node head){
        boolean res = true;
        getHeight(head,1,res);
        return res;
    }
    //返回以head为跟节点的子树的最大深度，同时更新全局变量res
    public static int getHeight(Node head,int level,boolean res){
        if(head==null){
            return level;
        }
        int lH = getHeight(head.left,level+1,res);
        if(!res){
            return level;
        }
        int rH = getHeight(head.right,level+1,res);
        if(!res){
            return level;
        }
        if(Math.abs(lH-rH)>1){
            res = false;
        }
        return Math.max(lH,rH);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }
}
