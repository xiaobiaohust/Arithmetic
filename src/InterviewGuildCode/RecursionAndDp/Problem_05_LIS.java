package InterviewGuildCode.RecursionAndDp;

/**
 * 最长递增子序列
 * 给定数组arr，返回arr的最长递增子序列
 */
public class Problem_05_LIS {
    /**
     * 方法一：时间复杂度O(N^2)
     * 思路：
     * 1、dp[i]表示以arr[i]这个数结尾的情况下，arr[0:i]中的最大递增子序列长度
     *      dp[0]=1,假设计算到dp[i],求以arr[i]结尾的最长递增子序列，那么arr[0:i-1]
     *      中比arr[i]小的数都可以作为倒数第二个数，从中选择对于dp最大的
     * 2、左到右遍历dp之后，找到最大的值及其对应的位置k，就可以得到最长递增序列的长度及结尾
     *    位置。
     *    在从序列最后的位置从右向左遍历，如果arr[i]<arr[k]，且dp[k]=dp[i]+1,
     *    则可以令i位置为倒数第二个元素，依次找到下一个元素，则可以找到最长递增序列
     */
    public static int[] lis1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    public static int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    /**
     * 方法二：时间复杂度O(NlogN),使用二分查找来优化生成dp数组
     */
    public static int[] lis2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    /**
     * 通过使用一个数组ends，ends[b]=c表示在遍历数组过程中，所有长度为b+1的子序列中，最小的结尾数是c
     * 可以判断ends会是一个升序数组，在一个升序数组中找到最左边的大雨或等于的，可以使用
     * 二分查找，从而使得时间复杂度降为O(NlogN)
     *
     * @param arr
     * @return
     */
    public static int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        dp[0] = 1;
        ends[0] = arr[0];
        int right = 0;
        for (int i = 1; i < arr.length; ++i) {
            int l = 0;
            int r = right;
            while (l<=r){
                int m = (l+r)/2;
                if(arr[i]>ends[m]){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
            right =Math.max(right,l);
            ends[l] = arr[i];
            dp[i] = l+1;
        }
        return dp;

    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7,11};
        printArray(arr);
        printArray(lis1(arr));
        printArray(lis2(arr));

    }
}



