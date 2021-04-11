package InterviewGuildCode.RecursionAndDp;

/**
 * 最长公共子序列问题
 * 给定两个字符串，返回两个字符串的最长公共子序列
 */
public class Problem_07_LCSubsequence {

    /**
     * 方法一：使用动态规划，如果str1的长度为M，str2的长度为N，生成大小M x N的矩阵dp
     * dp[i][j]的含义是str1[0：i]与str2[0:j]的最长公共子序列的长度
     * 1：第一列，只要str1中出现一个数和str2[0]相等，之后所有的都是1
     * 2：第一行，只要str2中出现一个数和str1[0]相等，之后所有的都是1
     * 3：对其他位置（i,j）
     * * 可能是dp[i-1][j]。str1[i]与str2[j]不相等，str1[i]不在子序列当中
     * * 可能是dp[i][j-1]。str1[i]与str2[j]不相等，str2[j]不在子序列当中
     * * dp[i-1][j-1]+1。str1[i]与str2[j]相等
     *
     * 时间复杂度O(MxN)，如果不要求需要返回最长公共子序列，只求长度，
     * 可以使用空间压缩的方法降低空间复杂度
     */
    public static String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return "";
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        char[] res = new char[dp[chs1.length - 1][chs2.length - 1]];
        int index = res.length - 1;
        int m = chs1.length-1;
        int n = chs2.length-1;
        while (index>=0){
            if(n>0&&dp[m][n]==dp[m][n-1]){
                n--;
            }else if(m>0&&dp[m][n]==dp[m-1][n]){
                m--;
            }else{
                res[index--] = chs1[m];
                m--;
                n--;
            }

        }
        return String.valueOf(res);
    }



    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 1; i < str2.length; ++i) {
            dp[0][i] = Math.max(dp[0][i - 1], str2[i] == str1[0] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; ++i) {
            for (int j = 1; j < str2.length; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str1 = "A1BC2D3EFGH45I6JK7LMN";
        String str2 = "12OPQ3RST4U5V6W7XYZ";
        System.out.println(lcse(str1, str2));

    }
}
