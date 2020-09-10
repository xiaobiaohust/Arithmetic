package LeetCode.StringProblem;

/**
 * 添加最少字符使字符串整体都是回文字符串
 */
public class Problem_13_PalindromeString {
    /**
     * 思路：使用动态规划求解，建一个NxN的矩阵dp,dp[i][j]代表子串
     * str[i~j]最少添加几个字符可以使str[i~j]整体都是回文串
     * 1：求dp[i][j]有三种情况：
     * 1：str[i~j]只有一个字符，dp[i][j]=0
     * 2：str[i~j]只有两个字符，相等则dp[i][j]=0,否则dp[i][j]=1
     * 3：str[i~j]超过两个字符，
     * 如果str[i]=str[j],则dp[i][j]=dp[i+1][j-1]
     * str[i]!=str[j],则dp[i][j] = min(dp[i+1][j],dp[i][j-1])+1
     * <p>
     * 2：根据dp,求回文串的结果，记回文串为res,res的长度为dp[0][N-1]+str的长度
     * 依次设置res的两头
     * str[i]=str[j]
     * str[i]!=str[j]
     */

    public static String getPalindrome1(String str){
        if(str==null||str.length()==0){
            return str;
        }
        char[]chas = str.toCharArray();
        int[][]dp = getDP(chas);
        char[] res= new char[chas.length+dp[0][chas.length-1]];
        int resl = 0;
        int resr = res.length-1;
        int i=0;
        int j=chas.length-1;
        while (i<=j){
            if(chas[i]==chas[j]){
                res[resl++] = chas[i++];
                res[resr--] = chas[j--];
            }else if(dp[i+1][j]<dp[i][j-1]){
                res[resl++] = chas[i];
                res[resr--] = chas[i++];
            }else{
                res[resl++] = chas[j];
                res[resr--] = chas[j--];
            }
        }
        return String.valueOf(res);
    }

    public static int[][] getDP(char[] str) {
        int[][] dp = new int[str.length][str.length];
        for (int j = 1; j < str.length; j++) {
            dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
            for (int i = j - 2; i > -1; i--) {
                if(str[i]==str[j]){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str = "AB1CD2EFG3H43IJK2L1MN";
        System.out.println(getPalindrome1(str));


    }
}
