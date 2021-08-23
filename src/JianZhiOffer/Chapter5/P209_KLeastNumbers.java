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
        int index = partition(arr,left,right);
        return 1;
    }

    public static  int partition(int[]arr,int left,int right){
        int pivot = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot) right--;
            while (left<right&&arr[left]<pivot)left++;
            if(left<right) swap(arr,left,right);

        }
        return left;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
    public int partition(int[] array,int low,int high,int k){
        int temp = array[low];
        while(low!=high){
            while(low<high&&array[high]>=temp)
                high--;
            array[low] = array[high];
            while(low<high&&array[low]<=temp)
                low++;
            array[high] = array[low];
        }

        array[low] = temp;
        return low;
    }
}
