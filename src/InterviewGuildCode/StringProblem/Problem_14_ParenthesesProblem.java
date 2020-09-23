package InterviewGuildCode.StringProblem;

/**
 * 括号字符串的有效性和最长有效长度
 * 题1：给定一个字符串str，判断是不是整体有效的括号字符串
 * 题2：给定一个括号字符串str，返回最长的有效括号子串
 */
public class Problem_14_ParenthesesProblem {
    /**
     * 题一：
     * 1：括号字符串只能含义括号，有其他字符直接返回
     * 2：遍历每一个字符，如果出现')'更多，则直接返回
     * 3：遍历完成后，'('和')'一样多，则返回true
     */
    public static  boolean isValid(String str){
        if(str==null||str.length()==0){
            return false;
        }
        char[]chs = str.toCharArray();
        int status = 0;
        for(int i=0;i<chs.length;++i){
            if(chs[i]!='('&&chs[i]!=')'){
                return false;
            }
            if(chs[i]==')'&&--status<0){
                return false;
            }
            if(chs[i]=='('){
                status++;
            }
        }
        return status==0;
    }
    /**
     * 题二：
     * 使用动态规划，时间复杂度O(N)，空间复杂度O(N)
     */

    public static int maxLength(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "((())())";
        System.out.println(isValid(str1));
        System.out.println(maxLength(str1));

        String str2 = "(())(()(()))";
        System.out.println(isValid(str2));
        System.out.println(maxLength(str2));

        String str3 = "()(()()(";
        System.out.println(isValid(str3));
        System.out.println(maxLength(str3));

    }
}
