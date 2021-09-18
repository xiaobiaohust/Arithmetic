package MyInterviewRecord;

/**
 * 编辑距离
 */
public class 得物2 {
    public static int fun(String str1,String str2){
        char[]chs1 = str1.toCharArray();
        char[]chs2 = str2.toCharArray();
        int M = chs1.length;
        int N  = chs2.length;
        int[][]dp = new int[M+1][N+1];
        for(int i=1;i<N+1;++i){
            dp[0][i] = i;
        }
        for(int i=1;i<M+1;++i){
            dp[i][0] = i;
        }
        for(int i=1;i<M+1;++i){
            for(int j=1;j<N+1;++j){
                dp[i][j] = chs1[i-1]==chs2[j-1]?dp[i-1][j-1]:dp[i-1][j-1]+1;
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
            }
        }
        return dp[M][N];
    }





}
