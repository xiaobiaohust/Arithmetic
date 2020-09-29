package InterviewGuildCode.Others;

/**
 * 在有序旋转数组中找到最小值
 * 有序数组可能经过一次旋转处理，也可能没有，且可能存在重复的数，返回
 * arr中的最小值
 * 思路一：暴力求解，通过遍历寻找最小值，O(N)
 * 思路：数组只是旋转了一下，还是局部有序的，一般采取二分查找
 */
public class Problem_19_SortedRatateArrayFindMin {
    public static int getMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            if (low == high - 1) {
                break;
            }
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            mid = (low + high) / 2;
            if (arr[low] > arr[mid]) {
                high = mid;
                continue;
            }
            if (arr[mid] > arr[high]) {
                low = mid;
                continue;
            }
            while (low < mid) {
                if (arr[low] == arr[mid]) {
                    low++;
                } else if (arr[low] < arr[mid]) {
                    return arr[low];
                } else {
                    high = mid;
                    break;
                }
            }
        }
        return Math.min(arr[low], arr[high]);
    }

    public static void main(String[] args) {
        int[] test = { 4, 5, 5, 5, 1, 2, 3 };
        System.out.println(getMin(test));

    }

}
