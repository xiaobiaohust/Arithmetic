package InterviewGuildCode.BinaryTree;

/**
 * 找到二叉树中的最大搜索二叉子树
 * 给定一棵二叉树的头结点head，已知所有节点的值都不一样，找到含有节点最多的
 * 搜索二叉子树，并返回这棵子树的头结点
 * 要求：时间复杂度O(N)，空间复杂度O(h)
 * 思路：后序遍历
 * 1：判断整棵树是否是搜索二叉树，如果是，则直接返回，不是则判断左子树和右子树中的
 * 搜索二叉树，两者节点数较多的则返回。
 * 2：使用后序遍历的方式，因为后序遍历先左子树，在右子树，最后到跟节点
 * 3：对于每个节点cur，找到左子树的最大搜索二叉树，返回对应的跟节点，节点数
 * 最大值、最小值；右子树同样求得最大搜索二叉树，使用1的判断方法
 */
public class Problem_07_BiggestSubBSTInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node biggestSubBST(Node head) {
        int[] record = new int[3];//0->size,1->min,2->max
        return posOrder(head, record);
    }

    /**
     * 采取后序遍历的方式
     *
     * @param head
     * @param record，全局变量，想这种递归处理，前一个递归处理的结果作为 结果
     *  传给下一个递归，有些耦合，让人难以理解。但是其实
     *  这个递归参数对本递归是没有作用的，只是存储递归返回的些参数而已
     * @return
     */
    public static Node posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }

        int value = head.value;
        Node left = head.left;
        Node right = head.right;

        Node lBST = posOrder(left,record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];

        Node rBST = posOrder(right,record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];

        if(left==lBST&&right==rBST&&lMax<value&&value<rMin){
            record[0] = lSize+rSize+1;
            record[1]=Math.min(lMin,value);
            record[2] = Math.max(rMax,value);
            return head;
        }else if(lSize>rSize){
            record[0] = lSize;
            record[1]=lMin;//多余,因为此时返回以后，需要用到的只是size字段
            record[2] = lMax;//多余
            return lBST;
        }else{
            record[0] = rSize;
            record[1]=rMin; //多余
            record[2] = rMax;//多余
            return rBST;
        }

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

        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);

        printTree(head);
        Node bst = biggestSubBST(head);
        printTree(bst);

    }

}
