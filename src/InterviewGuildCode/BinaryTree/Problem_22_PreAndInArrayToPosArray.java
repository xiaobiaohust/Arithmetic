package InterviewGuildCode.BinaryTree;

import java.util.HashMap;

/**
 * 通过先序和中序数组生成后序数组
 *
 * 方法一：利用先序和中序重构二叉树，在后序遍历
 * 方法二：在重构二叉树的过程中生成后序数组
 */
public class Problem_22_PreAndInArrayToPosArray {
    public static int[] getPoseArray(int[]pre,int[] in){
        if(pre==null||in==null){
            return null;
        }
        int len = pre.length;
        int[]pos = new int[len];
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<len;++i){
            map.put(in[i],i);
        }
        setPos(pre,0,len-1,in,0,len-1,pos,len-1,map);
        return pos;
    }

    /**
     * 从右往走依次填好后序数组s,si为后序数组该填的位置，
     * 返回值为下一个该填的位置
     * @param p
     * @param pi
     * @param pj
     * @param n
     * @param ni
     * @param nj
     * @param s
     * @param si
     * @param map
     * @return
     */
    public static int setPos(int[]p,int pi,int pj,int[]n,int ni,int nj,int[]s,int si,HashMap<Integer,Integer>map){
        if(pi>pj){
            return si;
        }
        s[si--]=p[pi];
        int index = map.get(p[pi]);
        int lLen = index-ni;
        int rLen = nj-index;
        si = setPos(p,pj-rLen+1,pj,n,index+1,nj,s,si,map);
        return setPos(p,pi+1,pi+lLen,n,ni,index-1,s,si,map);

    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
        int[] in = { 4, 2, 5, 1, 6, 3, 7 };
        int[] pos = getPoseArray(pre, in);
        printArray(pos);

    }
}
