package InterviewGuildCode.ArrayAndMatrix;

/**
 * 数组的partition
 * 给定一个有序数组arr，调整arr使得这个数组左半部分没有重复元素且升序，
 * 而不保证右部分是否有序
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 */
public class Problem_23_PartitionArray {
    public static void leftUnique(int[]arr){
        if(arr==null||arr.length<2){
            return;
        }
        int unic = 0;
        int i = 0;
        while (++i<arr.length){
            if(arr[i]!=arr[unic]){
                swap(arr,++unic,i);
            }
        }

    }
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
        printArray(arr1);
        leftUnique(arr1);
        printArray(arr1);

        System.out.println();


    }
}
