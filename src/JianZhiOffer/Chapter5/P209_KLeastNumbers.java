package JianZhiOffer.Chapter5;

/**
 * 最小的k个数
 * 思路1： partition思想，直到找到第k个数，左边的全部是最小的。时间复杂度O(N)，需要修改数组，无法处理海量数据
 * 思路2：最大堆。时间复杂度O(NlogK)，不需要改数组，适合海量数据
 */
public class P209_KLeastNumbers {
    public static int getLeastNumbers(int[]arr,int k){
        if(arr==null||arr.length==0||arr.length<k) return 0;
        int left = 0;
        int right = arr.length-1;
        int index = par
    }

    public static  int partition(int[]arr,int left,int right){
        int pivot = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot) right--;
            if(left<right)
            while (left<right&&arr[])

        }
    }
}
