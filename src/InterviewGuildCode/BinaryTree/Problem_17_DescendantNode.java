package InterviewGuildCode.BinaryTree;

/**
 * 在二叉树中找一个节点的后继节点
 * 后继节点概念：在二叉树的中序遍历中，node节点的下一个节点叫做node的
 * 后继节点
 *
 * 方法一：该节点有父节点，找到头结点，在中序遍历，便可找到后继节点，
 * 时间复杂度O(N)，空间复杂度O(N)
 *
 * 方法二：
 * 1：如果node节点有右子树，则右子树最左边的节点是后继节点
 * 2：node没有右子树
 *      * node节点是父节点的左孩子，则后继节点是父节点
 *      * node节点是父节点的右孩子，则一直向上移动，
 *      * 特殊情况，最后一个节点，是没有后继节点
 */

public class Problem_17_DescendantNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getNextNode(Node node){
        if(node==null){
            return node;
        }
        if(node.right!=null){
            return getLeftMost(node.right);
        }else{
            Node parent= node.parent;
            while (parent!=null&&parent.left!=node){
                node = parent;
                parent =node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if(node==null){
            return node;
        }
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getNextNode(test));
    }

}
