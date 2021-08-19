package MyInterviewRecord;

public class test3 {
    public int min_operator(String word1, String word2) {
        // write co
        if (word1 == null || word2 == null) {
            return 0;
        }
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int row = ch1.length+1;
        int col = ch2.length+1;
        int [][]dp = new int[row][col];
        for(int i=1;i<row;++i){
            dp[i][0] = i;
        }
        for(int i=1;i<col;++i){
            dp[0][i] = i;
        }
        for(int i=1;i<row;++i){
            for(int j=1;j<col;++j){
                dp[i][j] = ch1[i-1]==ch2[j-1]?dp[i-1][j-1]:dp[i-1][j-1]+1;
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                dp[i][j] = Math.min(dp[i][j],dp[1][j-1]+1);
            }
        }
        return dp[row-1][col-1];
    }
}
