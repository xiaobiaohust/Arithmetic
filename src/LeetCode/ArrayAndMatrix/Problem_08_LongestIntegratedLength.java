package LeetCode.ArrayAndMatrix;

import java.util.HashSet;

/**
 * 最长的可整合子数组的长度
 * 整合数组定义，将一个数组排序之后，相邻两个数差的绝对值都为1，则为整合数组
 */
public class Problem_08_LongestIntegratedLength {
    public static int getLIL2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<Integer>(); // 判断重复
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) { // 新的检查方式
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 5, 3, 2, 6, 4, 3 };

        System.out.println(getLIL2(arr));

    }
}
