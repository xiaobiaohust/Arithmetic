package JianZhiOffer.Chapter4;

/**
 * 二叉搜索树的后序遍历序列
 * 给定一个数组，判断是否是搜索二叉树的后序遍历的结果
 * 思想：有点类似根据两个遍历序列重构二叉树
 * 1、首先最后一个元素是跟节点
 * 2、小于跟节点元素的是左子树的部分
 * 3、大于右子树的是右子树部分
 */
public class P179_SequenceOfBST {
    public static boolean VerifyArrayOFBST(int[]arr){
        if(arr==null||arr.length==0){
            return false;
        }
        return process(arr,0,arr.length-1);

    }
    public static boolean process(int[]arr,int start,int end){
        if(end-start<=1){
            return true;
        }
        int i=start;
        for(;i<end;++i){
            if(arr[i]>arr[end]){
                break;
            }
        }
        int j=i;
        for(;j<end;++j){
            if(arr[j]<arr[end]){
                return false;
            }
        }
        return process(arr,start,i-1)&&process(arr,i,end-1);
    }

    public static void main(String[] args){
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        int[] data = {5,7,6,9,4,10,8};
        int[] data1 = {5,7,6,9,11,10,8};
        System.out.println(VerifyArrayOFBST(data));
        System.out.println(VerifyArrayOFBST(data1));
    }
}
