package InterviewGuildCode.BinaryTree;

/**
 * 判断t1树是否包含t2树的全部拓扑结构
 * 时间复杂度O(NxM)
 * 思路：
 * 遍历t1的每个节点，若该节点与t2相同，则先序遍历t2，t1的节点跟着t2b遍历
 */
public class Problem_11_T1ContainsT2Topology {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    //遍历二叉树使用递归
    public static boolean contains(Node t1,Node t2){
        if(t2==null){
            return true;
        }
        if(t1==null){
            return false;
        }
        return check(t1,t2)||contains(t1.left,t2)||contains(t1.right,t2);
    }
    public static boolean check(Node t1,Node t2){
        if(t2==null){
            return true;
        }
        if(t1==null||t1.value!=t2.value){
            return false;
        }
        return check(t1.left,t2.left)&&check(t1.right,t2.right);
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.left = new Node(8);
        t1.left.left.right = new Node(9);
        t1.left.right.left = new Node(10);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.left = new Node(8);
        t2.right = new Node(5);

        System.out.println(contains(t1, t2));

    }

}
