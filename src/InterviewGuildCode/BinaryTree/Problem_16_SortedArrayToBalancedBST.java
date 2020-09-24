package InterviewGuildCode.BinaryTree;

/**
 * 通过有序数组生成平衡搜索二叉树
 * 给定一个有序数组sortArr，已知没有重复值，用该有序数组生成一棵平衡搜索
 * 二叉树，并且该二叉树的中序遍历结果与sortArr一致
 * 思路：
 * 有序数组生成搜索树有很多种，但是加上平衡的限制条件，生成的树就少了
 * 使用数组中间的数作为头结点，左边作为左子树，右边作为右子树
 */
public class Problem_16_SortedArrayToBalancedBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node generateTree(int[]arr){
        if (arr==null){
            return null;
        }
        return generate(arr,0,arr.length-1);
    }
    public static Node generate(int[]arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node head = new Node(arr[mid]);
        head.left = generate(arr,start,mid-1);
        head.right = generate(arr,mid+1,end);
        return head;
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
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        printTree(generateTree(arr));

    }


}
