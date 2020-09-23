package InterviewGuildCode.RecursionAndDp;

/**
 * 字符串的交错组成
 * 给定三个字符串str1，str2，aim，aim包含且仅包含来自str1和str2的所有字符，
 * 并且aim中属于str1的字符之间保持原来在str1中的顺序，属于str2的字符之间
 * 保持原来在str2中的顺序，那么称aim是str1和str2的交错组成，实现一个函数
 * 判断aim是否是str1和str3交错组成。
 * <p>
 * 方法一：经典动态规划时间复杂度O(MxN)，空间复杂度O(MxN)
 * 生成大小(M+1)x(N+1)的矩阵dp，dp[i][j]的值代表aim[0..i+j-1]能否被
 * str1[0~i-1]和str2[0~j-1]交错组成
 * 1：dp[0][0],当aim为空串时，可以被str1位空串和str2为空串交错组成
 * 2：第一列，如果aim[0~i-1]=str1[0~i-a]，则dp[i][0] = true
 * 3：第一行，如果aim[0~i-1]=str2[0~i-a]，则dp[0][i] = true
 */
public class Problem_10_StringCross {
    public static boolean isCross1(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        if (str1.length() + str2.length() != aim.length()) {
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        boolean[][] dp = new boolean[ch1.length + 1][ch2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < ch1.length + 1; ++i) {
            if (ch1[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i < ch2.length + 1; ++i) {
            if (ch2[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[0][i] = true;
        }
        for (int i = 1; i < ch1.length + 1; ++i) {
            for (int j = 1; j < ch2.length + 1; ++j) {
                if ((dp[i - 1][j] && ch1[i - 1] == chaim[i + j - 1]) ||
                        (dp[i][j - 1] && ch2[j - 1] == chaim[i + j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[ch1.length][ch2.length];

    }

    /**
     * 采用空间压缩降低空间复杂度O(Min(M,N))
     *
     * @param str1
     * @param str2
     * @param aim
     * @return
     */
    public static boolean isCross2(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        if (str1.length() + str2.length() != aim.length()) {
            return false;
        }
        char[] shorts = str1.length() < str2.length() ? str1.toCharArray() : str2.toCharArray();
        char[] longs = str1.length() < str2.length() ? str2.toCharArray() : str1.toCharArray();
        char[] chaim = aim.toCharArray();
        boolean[] dp = new boolean[shorts.length + 1];
        dp[0] = true;
        for (int i = 1; i < shorts.length + 1; ++i) {
            if (shorts[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[i] = true;
        }
        for (int i = 1; i < longs.length + 1; ++i) {
            dp[0] = dp[0] && longs[i - 1] == chaim[i - 1];
            for (int j = 1; j < shorts.length + 1; ++j) {
                if ((dp[j] && longs[i - 1] == chaim[i + j - 1])
                        || (dp[j - 1] && shorts[j - 1] == chaim[i + j - 1])) {
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        return dp[shorts.length];
    }

    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "abcd";
        String aim = "1a23bcd4";
        System.out.println(isCross1(str1, str2, aim));
        System.out.println(isCross2(str1, str2, aim));

    }

}
