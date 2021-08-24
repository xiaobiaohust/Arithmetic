package MyInterviewRecord.Tools;

import java.util.Arrays;

/**
 * 1、快排的一个时间复杂度是O(NlogN)
 */
public class Partition {

    // 普通partition,
    // 以第一个数为基准，小于的放左边，大于等于放右边
    public static int partition1(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) high--;
            if (low < high) arr[low] = arr[high];
            while (low < high && arr[low] < temp) low++;
            if (low < high) arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    // 高级一点的partition，能够区分相等元素，相等元素放中间，小于放左边，大于放右边
    //以最后一个数arr[high]为基准
    public static int[] partition2(int[] arr, int low, int high) {
        int less = low - 1;
        int more = high;
        while (low < more) {
            if (arr[low] > arr[high]) {
                swap(arr, low, --more);
            } else if (arr[low] < arr[high]) {
                swap(arr, low++, ++less);
            } else {
                low++;
            }
        }
        swap(arr,more,high);
        return new int[]{less+1,more};

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void  quickSort(int[]arr){
        if(arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);

    }
    public static void quickSort(int[]arr,int l,int r){
        if(l>=r){
            return;
        }
//        int p = partition1(arr,l,r);
//        quickSort(arr,l,p);
//        quickSort(arr,p+1,r);
        int []p = partition2(arr,l,r);
        quickSort(arr,l,p[0]-1);
        quickSort(arr,p[1]+1,r);
    }


    public static void main(String[] args) {
        int[] data1 = {3, 1, 3, 7, 5, 3, 1, 2, 4, 2};
        quickSort(data1);
        System.out.println(Arrays.toString(data1));

        int[] data2 = {3, 1, 3, 7, 5, 3, 1, 2, 4, 2};

        System.out.println(partition1(data2, 0, data1.length - 1));
        System.out.println(Arrays.toString(data2));
    }

}
