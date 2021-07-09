package InterviewGuildCode.BinaryTree;

import java.util.Stack;

/**
 * 二叉树的递归和非递归遍历
 */
public class Problem_01_PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 递归先序
     *
     * @param head
     */
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 递归中序
     *
     * @param head
     */
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 递归后序
     *
     * @param head
     */
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 非递归先序遍历
     * 思想：使用一个栈，先访问跟节点，出栈，然后将右孩子入栈，做孩子入栈，
     *
     * @param head
     */
    public static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    /**
     * 非递归中序遍历
     * 思想：每个节点都需要先入栈，访问左孩子之后再访问该节点
     *
     * @param head
     */
    public static void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    /**
     * 非递归后序遍历
     * 思想：每个节点都需要先入栈，访问左孩子之后再访问该节点
     *
     * @param head
     */
    public static void posOrderUnrecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }
        System.out.println();
    }

    //后序遍历，只使用一个stack
    //类似中序遍历，只不过在else中，需要先遍历右子树，在pop访问节点
    public static void posOrderUnrecur2(Node head){
        if(head==null){
            return;
        }
        Stack<Node>stack = new Stack<>();
        Node pre = null;
        while (head!=null||!stack.isEmpty()){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.peek().right;
                if(head!=null&&pre!=head){
                    stack.push(head);
                    head = head.left;
                }else{
                    pre = stack.pop();
                    System.out.print(pre.value+" ");
                    head = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnrecur(head);
        posOrderUnrecur2(head);


    }
}
