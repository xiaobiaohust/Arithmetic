package InterviewGuildCode.BinaryTree;

/**
 * 判断t1树是否有与t2树拓扑结构完全相同的子树
 * 思路一：与之前的题目增加了“子树”两个限制，之前是t1跟着t2遍历，
 * 可以增加t2跟着t1遍历，如果两个遍历都满足，则肯定是子树，时间复杂度为O(NxM)
 *
 * 思路二：时间复杂度O(N+M)
 * 1：子树会有一个特别大的一个特点，就是序列化后，子树的所有节点会在一起，
 * 可以将两个树全部序列化，看字符串是否包含，时间复杂度O(N+M)
 * 2：判断一个字符串是否是另一个的子串，可以使用KMP算法，时间复杂度O(N+M)
 *
 */
public class Problem_12_T1SubtreeEqualsT2 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isSubTree(Node t1,Node t2){
        String t1Str = serialByPre(t1);
        String t2Str = serialByPre(t2);
        return getIndexOf(t1Str,t2Str)!=-1;
    }

    public static String serialByPre(Node head){
        if(head==null){
            return "#!";
        }
        String res = head.value+"!";
        res+=serialByPre(head.left);
        res+=serialByPre(head.right);
        return res;
    }


    public static int getIndexOf(String s,String m){
        if(s==null||m==null||s.length()<m.length()){
            return -1;
        }
        char[]ss = s.toCharArray();
        char[]ms = m.toCharArray();
        int[]nextArr = getNextArray(ms);
        int si = 0;
        int mi = 0;
        while (si<ss.length&&mi<ms.length){
            if(ss[si]==ms[mi]){
                si++;
                mi++;
            }else if(nextArr[mi]==-1){
                //第一个数就不相等
                si++;
            }else{
                mi = nextArr[mi];
            }
        }
        return mi==ms.length?si-mi:-1;
    }

    public static int[]getNextArray(char[] ms){
        if(ms.length==1){
            return new int[]{-1};
        }
        int []next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = next[i-1];
        while (i<next.length){
            if(ms[i-1] ==ms[cn]){
                next[i++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(isSubTree(t1, t2));

    }


}
