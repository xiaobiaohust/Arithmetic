package InterviewGuildCode.BinaryTree;

/**
 * 根据后序数组重建搜索二叉树
 * 给定一个整型数组arr，已知其中没有重复值，判断arr是否可能是节点值类型为
 * 整型的搜索二叉树后序遍历结果
 * 思路：搜索二叉树的后序遍历，最后一个数是跟节点，比跟节点小的数是左子树
 * 的节点，比跟节点大的数作为右子树的节点，在分别判断左右子树是否是搜索二叉树
 */
public class Problem_14_PosArrayToBST {
    public static boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    public static boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }

        int less = -1;
        int more = end;
        for(int i=start;i<end;++i){
            if(arr[end]>arr[i]){
                less=i;
            }
            more= more==end?i:more;
        }
        //二叉树左右子树只有一个
        if(less==-1||more==end){
            return isPost(arr,start,end-1);
        }
        //右子树大于跟节点，左子树小于跟节点，所以左子树最大值一定和右子树
        //最小值相邻
        if(less!=more-1){
            return false;
        }
        return isPost(arr,start,less)&&isPost(arr,more,end-1);

    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 6, 5, 7, 4 };
        System.out.println(isPost(arr, 0, arr.length - 1));
        //printTree(posArrayToBST(arr));

    }
}
