package InterviewGuildCode.StringProblem;

/**
 * 回文最小分割数
 * 给定一个字符串str，返回str全部切成回文子串的最小分割数
 * 思想：使用动态规划解决
 * 1：定义数组dp，dp[i]的含义是子串str[i~len-1]子串需要切割几次，才能把
 * str[i~len-1]全部切成回文子串
 * 2：j从i到len-1遍历，在str[i-j]为回文串的情况下，求得dp[j]的最小值，dp[i] = dp[j]+1
 * 3：定义一个数组boolean[][]p判断str[i~j]是否是回文串
 *      str[i~j]一个字符
 *      str[i~j]两个字符且相等
 *      str[i]==str[j],且p[i+1][j-1]为true
 */
public class Problem_21_PalindromeMinCut {
    public static int minCut(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[]chs=str.toCharArray();
        int len = chs.length;
        int[]dp = new int[len+1];//加1是为了解决那种整个字符串就是回文
        dp[len] = -1;
        boolean[][]p = new boolean[len][len];
        for(int i=len-1;i>-1;--i){
            dp[i] = Integer.MAX_VALUE;
            for(int j=i;j<len;++j){
                if(chs[i]==chs[j]&&(j-i<2||p[i+1][j-1])){
                    p[i][j] = true;
                    dp[i] =Math.min(dp[i],dp[j+1]+1);
                }
            }

        }
        return dp[0];
    }
    // for test
    public static String getRandomStringOnlyAToD(int len) {
        int range = 'D' - 'A' + 1;
        char[] charArr = new char[(int) (Math.random() * (len + 1))];
        for (int i = 0; i != charArr.length; i++) {
            charArr[i] = (char) ((int) (Math.random() * range) + 'A');
        }
        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        int maxLen = 10;
        int testTimes = 5;
        String str = null;
        for (int i = 0; i != testTimes; i++) {
            str = getRandomStringOnlyAToD(maxLen);
            System.out.print("\"" + str + "\"" + " : ");
            System.out.println(minCut(str));
        }

    }
}
