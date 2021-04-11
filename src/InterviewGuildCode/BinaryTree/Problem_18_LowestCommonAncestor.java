package InterviewGuildCode.BinaryTree;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * 思路：
 * 1：分别判断左右子树是否包含两个节点，包含
 *      左右子树都包含，则左右子树各有一个，则公共祖先就是跟节点，返回跟节点
 *      左右子树只有一个包含，则说明两个节点都在同一侧，对该节点的子树继续遍历
 *      左右子树都不包含，则不存在
 * 所以采用后序遍历二叉树，假设遍历到的当前节点为cur，先处理两颗子树，判断是否包含，
 */
public class Problem_18_LowestCommonAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        printTree(head);
        System.out.println("===============");

        Node o1 = head.left.right;
        Node o2 = head.right.left;

        // 单次查询--原问题
        System.out.println("o1 : " + o1.value);
        System.out.println("o2 : " + o2.value);
        System.out.println("ancestor : " + lowestAncestor(head, o1, o2).value);
        System.out.println("===============");
    }
}
