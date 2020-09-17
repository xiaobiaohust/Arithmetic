package LeetCode.ArrayAndMatrix;

/**
 * 未排序正数数组中累加和为给定值得最长子数组的长度
 * 要求：时间复杂度O(N)，空间复杂度O(1)
 * 思路：
 * 1：两个指针left、right都从0开始向右滑动两个指针之间的和sum
 *      sum<k,right向右滑动
 *      sum=k,left+1，然后right继续向右滑动
 *      sum>k，left+1,
 */
public class Problem_10_LongestSumSubArrayLengthInPositiveArray {
    public static int getMaxLength(int[] arr,int k){
        if(arr==null||arr.length==0||k<=0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while(right<arr.length){
            if(sum==k){
                len = Math.max(len,right-left+1);
                sum -=arr[left++];
            }else if(sum<k){
                right++;
                if(right==arr.length){
                    break;
                }
                sum +=arr[right];
            }else{
                sum-=arr[left++];
            }
        }
        return len;
    }
    public static int[] generatePositiveArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10) + 1;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int len = 20;
        int k = 15;
        int[] arr = generatePositiveArray(len);
        printArray(arr);
        System.out.println(getMaxLength(arr, k));

    }
}
