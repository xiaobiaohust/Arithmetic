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
        int index = partition2(arr,left,right);
        return 1;
    }



    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }


    //普通的partition,一边小于，一边大于等于
    public static int partition2(int[] array,int low,int high){
        int temp = array[low];
        while(low<high){
            while(low<high&&array[high]>=temp)
                high--;
            array[low] = array[high];
            while(low<high&&array[low]<temp)
                low++;
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    public static void main(String[]args){
        int[] data1 = {6,1,3,5,4,2};
        System.out.println(partition2(data1,0,data1.length-1));
    }
}
