package MyInterviewRecord;

/**
 * 两个字符串，删除n个字符，使得两个字符串相等
 */
public class 货拉拉1 {
    public static int fun(String str1, String str2) {
        char[]chs1 = str1.toCharArray();
        char[]chs2 = str2.toCharArray();
        int M = chs1.length;
        int N = chs2.length;
        int[][]dp= new int[M+1][N+1];
        for(int i=1;i<N+1;++i){
            dp[0][i] = i;
        }
        for(int i=1;i<M+1;++i){
            dp[i][0] = i;
        }
        for(int i=1;i<M+1;++i){
            for(int j=1;j<N+1;++j){
                dp[i][j] = Integer.MAX_VALUE;
                if(chs1[i-1]==chs2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
            }
        }
        return dp[M][N];
    }
    public static void main(String[]args){
        String str1 = "a";
        String str2 = "bcd";
        System.out.println(fun(str1,str2));
    }
}
