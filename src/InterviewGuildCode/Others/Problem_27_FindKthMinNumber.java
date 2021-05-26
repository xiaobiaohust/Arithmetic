package InterviewGuildCode.Others;

import java.util.Arrays;

/**
 * 在两个排序数组中找到第K小的数
 * 要求：时间复杂度O(log(min(M,N)))，额外空间复杂度O(1)
 * 思路1：
 * 求第K小的数，最开始的想法是最大堆，但是空间复杂度不满足要求
 * <p>
 * 思路2：利用之前的求两个长度相同排序数组的上中位数
 * 假设长度较短的数组shortArr长S，长度较长的数组longArr长L
 * 1：K<1 或者 K>S+L,
 * 2：K<S，，则在长短两个数组的最前面分别取K个元素，求中位数
 * 3：K>L，令m=L+S-K,则shortArr中[1,S-m-1],不可能是第K个元素,而且是之前的元素；
 * longArr中[1,L-m-1]也不可能是第K个元素，而且是之前的元素，
 * 如果shortArr[S-m]大于longArr最后一个元素，则shortArr[S-m]是第K个元素
 * 如果longArr[L-m]大于shortArr最后一个元素，则longArr[L-m]是第K个元素
 * 以上都不是则在shortArr[S-m+1:S],longArr[L-m-1:L]求取中位数
 * 4：S<k<L，对于shortArr都有可能是是第K个元素，对于longArr[k-S:K]可能是第K个元素
 * 判断longArr[k-S]是否大于shortArr最后一个元素，大于则直接返回longArr[k-S]
 * 小于，则在shortArr[1:S],longArr[k-s+1,k]求取中位数
 */
public class Problem_27_FindKthMinNumber {
    public static int findKthNum(int[] arr1, int[] arr2, int K) {
        if (arr1 == null || arr2 == null || K < 1 || K > arr1.length + arr2.length) {
            throw new RuntimeException("valid");
        }
        int[] longArr = arr1.length > arr2.length ? arr1 : arr2;
        int[] shortArr = arr1.length <= arr2.length ? arr1 : arr2;
        int S = shortArr.length;
        int L = longArr.length;
        if (K <= S) {
            return getUpMedian(shortArr, 0, K - 1, longArr, 0, K - 1);
        }
        if (K > L) {
            if (shortArr[K - L - 1] >= longArr[L - 1]) {
                return shortArr[K - L - 1];
            }
            if (longArr[K - S - 1] >= shortArr[S - 1]) {
                return longArr[K - S - 1];
            }
            return getUpMedian(shortArr, 0, S - 1, longArr, K - S, L - 1);
        }
        if (longArr[K - S - 1] >= shortArr[S - 1]) {
            return longArr[K - S - 1];
        }
        return getUpMedian(shortArr, 0, S - 1, longArr, K - S, K - 1);

    }

    public static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2) {
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (s1 < e1) {
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            offset = ((e1 - s1 + 1) & 1) ^ 1;
            if (a1[mid1] > a2[mid2]) {
                e1 = mid1;
                s2 = mid2 + offset;
            } else if (a1[mid1] < a2[mid2]) {
                s1 = mid1 + offset;
                e2 = mid2;
            } else {
                return a1[mid1];
            }
        }
        return Math.min(a1[s1], a2[s2]);
    }

    // For test, this method is inefficient but absolutely right
    public static int[] getSortedAllArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Your arr is invalid!");
        }
        int[] arrAll = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i = 0; i != arr1.length; i++) {
            arrAll[index++] = arr1[i];
        }
        for (int i = 0; i != arr2.length; i++) {
            arrAll[index++] = arr2[i];
        }
        Arrays.sort(arrAll);
        return arrAll;
    }

    public static int[] generateSortedArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != len; i++) {
            res[i] = (int) (Math.random() * (maxValue + 1));
        }
        Arrays.sort(res);
        return res;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int len1 = 10;
        int len2 = 23;
        int maxValue1 = 20;
        int maxValue2 = 100;
        int[] arr1 = generateSortedArray(len1, maxValue1);
        int[] arr2 = generateSortedArray(len2, maxValue2);
        printArray(arr1);
        printArray(arr2);
        int[] sortedAll = getSortedAllArray(arr1, arr2);
        printArray(sortedAll);
        int kth = 17;
        System.out.println(findKthNum(arr1, arr2, kth));
        System.out.println(sortedAll[kth - 1]);

    }
}
