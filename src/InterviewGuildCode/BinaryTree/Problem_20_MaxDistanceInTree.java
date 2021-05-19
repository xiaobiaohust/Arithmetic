package InterviewGuildCode.BinaryTree;

/**
 * 二叉树节点间的最大距离
 * 二叉树从A点出发，可以向上或者向下走，沿途节点只能经过一次，到达B点时，路径上的节点数
 * 叫做A和B的距离，求整棵树上节点间的最大距离
 * 要求：时间复杂度O(N)
 *思路：
 * 一个以H为根节点的二叉树，最大距离只能来源于三种情况
 *      H的左子树上的最大距离
 *      H的右子树上的最大距离
 *      H左子树上离H.left最远的距离+1+H右子树上离H.right最远的距离
 * 三种情况最大的就是整棵树的最远的距离
 *
 * 1：整个过程为后续遍历，在二叉树的每棵子树上执行步骤2
 * 2：处理左子树，得到最大距离，以及离左子树根节点的最大距离；处理右子树，得到最大距离，
 * 以及离右子树根节点的最大距离，合并答案.x需要返回两个答案，则返回一个，其他的使用全局变量
 */
public class Problem_20_MaxDistanceInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static int maxDistance(Node head){
        int[]record = new int[1];
        return posOrder(head,record);
    }
    public static int posOrder(Node head,int[]record){
        if(head==null){
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left,record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right,record);
        int maxFromRight = record[0];

        record[0] = Math.max(maxFromLeft,maxFromRight)+1;
        return Math.max(Math.max(lMax,rMax),maxFromLeft+maxFromRight+1);

    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(maxDistance(head1));

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(maxDistance(head2));

    }

}
