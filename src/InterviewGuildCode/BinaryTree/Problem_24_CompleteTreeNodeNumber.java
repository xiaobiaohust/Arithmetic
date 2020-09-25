package InterviewGuildCode.BinaryTree;

/**
 *统计完全二叉树的节点数
 * 给定一个完全二叉树的头结点head，返回这棵树的节点个数
 * 要求：时间复杂度低于O(N)
 *
 * 方法一：遍历二叉树，可以求得树的节点个数，但是不是最优解
 * 方法：时间复杂度O(h^2)
 * 1：空树直接返回
 * 2：求树的高度h
 * 3：递归求解，bs(node,l,h)，node当前节点，l当前节点的高度，h整棵树的
 * 高度，返回以当前节点为跟节点的完全二叉树的节点数。判断node右子树的
 * 最左节点，如果高度等于h,说明node节点的左子树是满二叉树，不等于说明
 * 右子树是满二叉树，在递归下去
 */
public class Problem_24_CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int nodeNum(Node head){
        if(head==null){
            return 0;
        }
        return bs(head,1,mostLeftLevel(head,1));
    }

    public static int bs(Node head,int level,int h){
        if(level==h){
            return 1;
        }
        if(mostLeftLevel(head.right,level+1)==h){
            return (1<<(h-level))+bs(head.right,level+1,h);
        }else{
            return (1<<(h-level-1))+bs(head.left,level+1,h);
        }
    }

    public static int mostLeftLevel(Node node,int level){
        while (node!=null){
            level++;
            node = node.left;
        }
        return level-1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }

}
