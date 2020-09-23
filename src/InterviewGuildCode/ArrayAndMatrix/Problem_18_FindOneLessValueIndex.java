package InterviewGuildCode.ArrayAndMatrix;

/**
 * 在数组中找到一个局部最小的位置
 * 给定无序数组arr，任意两个相邻的数都不相等
 * 要求：时间复杂度O(logN)，额外空间复杂度O(1)
 * 思路：
 * 1：arr为空或者长度为0，返回-1表示不存在
 * 2：arr长度为1或者arr[0]<arr[1],返回0
 * 3：arr[N-1]<arr[N-2],返回N-1
 * 4：arr长度大于2，且左右两端都不是局部最小，令left=1，right=N-2，使用
 * 二分法查找
 * 5：二分查找，确定mid，如果arr[mid-1]<arr[mid],则在[left,mid-1]之间
 * 反之在[mid+1,right]之间
 */
public class Problem_18_FindOneLessValueIndex {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 1;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if(arr[mid-1]<arr[mid]){
                right = mid-1;
            }else if(arr[mid+1]<arr[mid]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }

}
