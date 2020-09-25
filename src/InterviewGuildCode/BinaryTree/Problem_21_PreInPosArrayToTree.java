package InterviewGuildCode.BinaryTree;

import java.util.HashMap;

/**
 * 先序、中序、后序数组两两结合重构二叉树
 */
public class Problem_21_PreInPosArrayToTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    /**
     * 先序与中序结合，时间复杂度为O(N)
     * 1：先序数组最左边的节点是跟节点，记为h
     * 2：中序数组找到h,h左边的是h的左子树的中序数组，个数为l
     *      右边的是右子树的中序数组，个数为r
     * 3：先序数组除第一个节点职外，前l个是左子树的先序数组，后r个是右子树的
     * 先序数组
     * 4：递归建立左右子树
     */

    public static Node preInToTree(int[]pre,int[]in){
        if(pre==null||in==null){
            return null;
        }
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<in.length;++i){
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    public static Node preIn(int[]p,int pi,int pj,int[]n,int ni,int nj,HashMap<Integer,Integer>map){
        if(pi>pj){
            return null;
        }
        Node head = new Node(p[pi]);
        int index = map.get(p[pi]);
        head.left =preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right = preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }

    /**
     * 中序和后序的结合，与先序和中序类似，只是后序的跟节点在最右边
     */
    public static Node inPosToTree(int[] in, int[] pos) {
        if (in == null || pos == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return inPos(in, 0, in.length - 1, pos, 0, pos.length - 1, map);
    }

    public static Node inPos(int[] n, int ni, int nj, int[] s, int si, int sj,
                             HashMap<Integer, Integer> map) {
        if (si > sj) {
            return null;
        }
        Node head = new Node(s[sj]);
        int index = map.get(s[sj]);
        head.left = inPos(n, ni, index - 1, s, si, si + index - ni - 1, map);
        head.right = inPos(n, index + 1, nj, s, si + index - ni, sj - 1, map);
        return head;
    }

    /**
     * 先序和后序，所有节点除了叶子节点之外，都有左右孩子，才能被重构除来
     */



}
