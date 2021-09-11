package MyInterviewRecord;

/**
 * 编辑距离
 */
public class 超参数 {
    public static int fun(String str1, String str2) {
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int dp[][] = new int[chs1.length + 1][chs2.length + 1];
        for (int i = 1; i < chs2.length + 1; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i < chs1.length + 1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i < chs1.length + 1; ++i) {
            for (int j = 1; j < chs2.length + 1; ++j) {
                dp[i][j] = chs1[i-1] == chs2[j-1] ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]+1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]+1);
            }
        }
        return dp[chs1.length][chs2.length];
    }

    public static void main(String[] args) {
        String str1 = "acabbba";
        String str2 = "aabbbb";
        System.out.println(fun(str1, str2));
    }
}
