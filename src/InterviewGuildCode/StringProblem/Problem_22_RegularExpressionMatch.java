package InterviewGuildCode.StringProblem;

/**
 * 字符串匹配
 */
public class Problem_22_RegularExpressionMatch {
    /**
     * 使用递归解决
     * 递归函数process(str,exp,si,ei)表示从str的si位置开始一直到str结束
     * 位置的子串，str[si~len]能否被exp[ei~len]匹配
     * 1：递归结束：ei为exp结束位置，si为str结束位置
     * 2：ei的下一个位置不为*，需要关注当前字符串能否匹配
     * 3：ei下一个位置为*，则需要遍历
     */
    public static boolean isValid(char[] s, char[] e) {
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == '*' || s[i] == '.') {
                return false;
            }
        }
        for (int i = 0; i < e.length; ++i) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return isValid(s, e) ? process(s, e, 0, 0) : false;
    }

    public static boolean process(char[] s, char[] e, int si, int ei) {
        // ei结束，看是否结束
        if (ei == e.length) {
            return si == s.length;
        }
        //e[ei+1]不为*
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (e[ei] == s[si] || e[ei] == '.') && process(s, e, si + 1, ei + 1);
        }
        //e[ei+1]为*,*从0次开匹配
        while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
            if (process(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        // 还剩下最后一次，比如假设只有一个元素相同，上述while只有0次匹配，而没有1次匹配
        return process(s, e, si, ei + 2);
    }

    /**
     * 使用动态规划
     *
     * @param str
     * @param exp
     * @return
     */
    public static boolean isMatchDP(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        if (!isValid(s, e)) {
            return false;
        }
        boolean[][] dp = initDPMap(s, e);
        for (int i = s.length - 1; i > -1; i--) {
            for (int j = e.length - 2; j > -1; j--) {
                if (e[j + 1] != '*') {
                    dp[i][j] = (s[i] == e[j] || e[j] == '.')
                            && dp[i + 1][j + 1];
                } else {
                    int si = i;
                    while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
                        if (dp[si][j + 2]) {
                            dp[i][j] = true;
                            break;
                        }
                        si++;

                    }
                    if (dp[i][j] != true) {
                        dp[i][j] = dp[si][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static boolean[][] initDPMap(char[] s, char[] e) {
        int slen = s.length;
        int elen = e.length;
        boolean[][] dp = new boolean[slen + 1][elen + 1];
        dp[slen][elen] = true;
        for (int j = elen - 2; j > -1; j = j - 2) {
            if (e[j] != '*' && e[j + 1] == '*') {
                dp[slen][j] = true;
            } else {
                break;
            }
        }
        if (slen > 0 && elen > 0) {
            if ((e[elen - 1] == '.' || s[slen - 1] == e[elen - 1])) {
                dp[slen - 1][elen - 1] = true;
            }
        }
        return dp;
    }


    public static void main(String[] args) {
        String str = "abcccdefg";
        String exp = "ab.*d.*e.*";
        System.out.println(isMatch(str, exp));
        System.out.println(isMatchDP(str, exp));

    }
}
