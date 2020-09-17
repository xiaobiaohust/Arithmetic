package LeetCode.ArrayAndMatrix;

/**
 * 需要排序的最短子数组长度
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 * 思路：
 * 1：从右到左遍历，记录遍历的最小值min，假设当前数arr[i]，如果arr[i]>min,
 * 说明如果要整体有序，arr[i]和min必须要交换，用noMinIndex记录最左边出现的位置
 * 2：从左到右遍历，遍历记录最大值，如果arr[i]<max，说明如果要整体有序，
 * arr[i]和max必须要交换，用noMaxIndex记录最右边出现的位置
 */
public class Problem_05_MinLengthForSort {

    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[arr.length - 1];
        int noMinIndex = -1;
        for (int i = arr.length - 2; i > -1; --i) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        // 已经整体有序
        if (noMinIndex == -1) {
            return 0;
        }
        int max = arr[0];
        int noMaxIndex = -1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
        System.out.println(getMinLength(arr));

    }
}
