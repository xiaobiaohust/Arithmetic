package LeetCode.ArrayAndMatrix;

/**
 * 自然数组排序
 * 给定一个长度为N的整形数组arr，有N个互不相等的自然数1~N。实现arr的排序
 * 要求：时间复杂度O(N)，额外空间复杂度（1）
 * 思路：从左到右遍历，如果该位置的元素不需要动，则下一个位置，需要动，则把
 * 该元素放到正确的位置上去，一直下去，每次会放置一个正确位置
 */
public class Problem_14_SortNaturalNumberArray {
    public static void sort1(int[] arr) {
        int tmp = 0;
        for (int i = 0; i != arr.length; i++) {
            while (arr[i] != i + 1) {
                tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 8, 2, 1, 6, 9, 3, 7, 5, 4 };
        sort1(arr);
        printArray(arr);

    }
}
