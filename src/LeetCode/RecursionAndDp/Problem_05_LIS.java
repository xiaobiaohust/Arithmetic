package LeetCode.RecursionAndDp;

import org.omg.CORBA.MARSHAL;

/**
 * 最长递增子序列
 * 给定数组arr，返回arr的最长递增子序列
 */
public class Problem_05_LIS {
    /**
     * 方法一：时间复杂度O(N^2)
     * dp[i]表示以arr[i]这个数结尾的情况下，arr[0:i]中的最大递增子序列长度
     */
    public static int getdp1(int[]arr){
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;++i){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp
    }
}
