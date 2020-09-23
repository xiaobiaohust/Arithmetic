package InterviewGuildCode.ArrayAndMatrix;

/**
 * 计算数组的小和
 * 数组小和定义：每一个数左边小于等于该数的和组成的数组在求和
 * 方法一：暴力解法，时间复杂度O(N^2)
 * 方法二：时间复杂度O(NlogN),额外空间复杂度O(1)
 * 思路：在归并排序的过程中，利用组间在进行合并时产生小和的过程。归并排序的过程
 * 就是会进行先拆组在合并的过程
 * 1：假设左数组l[],右数组r[],两个数组都已经有序，利用外排合成一个大数组
 * 2：在合成的过程中，如果l[i]<r[j],假设从r[j]一直到结束元素个数为m,则
 * 产生的小和为l[i]*m
 * 1：
 */
public class Problem_13_SmallSum {
    public static int getSmallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return func(arr, 0, arr.length - 1);
    }

    public static int func(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return func(arr, l, mid) + func(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] h = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int hi = 0;
        int smallSum = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                smallSum += arr[i] * (right - j + 1);
                h[hi++] = arr[i++];
            } else {
                h[hi++] = arr[j++];
            }
        }
        for (; (j < right + 1) || (i < mid + 1); ++i, ++j) {
            h[hi++] = i > mid ? arr[j] : arr[i];
        }
        for (int k = 0; k < h.length; k++) {
            arr[left++] = h[k];
        }
        return smallSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 6, 2, 7, 8, 1};
        System.out.println(getSmallSum(arr));

    }
}
