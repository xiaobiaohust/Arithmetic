package InterviewGuildCode.RecursionAndDp;

/**
 * 最长公共子串问题
 * 给定两个字符串str1，长度为M，str2，长度为N，返回两个字符串的最长公共子串，
 * 要求：时间复杂度O(MxN)，额外空间复杂度为O(1)
 */
public class Problem_08_LCSubstring {

    /**
     * 经典的动态规划时间复杂度O(MxN)，空间复杂度O(MxN)
     * 生成大小M小N的dp矩阵，dp[i][j]的含义，在必须把str1[i]和str2[j]当做
     * 公共子串最后一个字符的情况下，公共子串的最大长度
     * 1：第一行，str2[i]==str1[0],则dp[0][i]=1,否则dp[0][i]=0
     * 2：第一列，str1[i]==str2[0],则dp[i][0]=1,否则dp[i][0]=0
     * 3：其他位置从左到右，从上到下，dp[i][j]的值有两种情况
     * str1[i]!=str2[j]，则dp[i][j]=0
     * str1[i]==str2[j],则dp[i][j]=dp[i-1][j-1]+1
     */
    public static String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int max = 0;
        int ends = 0;
        int[][] dp = getdp(chs1, chs2);
        for (int i = 0; i < chs1.length; ++i) {
            for (int j = 0; j < chs2.length; ++j) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    ends = i;
                }
            }
        }
        return str1.substring(ends - max + 1, ends + 1);
    }


    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; ++i) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < str2.length; ++i) {
            if (str2[i] == str1[0]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < str1.length; ++i) {
            for (int j = 1; j < str2.length; ++j) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    /**
     * 方法二：空间复杂度由O(MxN)减少至O(1)
     * 思路：计算dp[i][j]只利用到了其左上角dp[i-1][j-1]的值，可以按照
     * 斜线方向来计算所有的值，只需一个变量。
     * @param str1
     * @param str2
     * @return
     */
    public static String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = 0;//斜线开始位置的行
        int col = chs2.length - 1;//斜线开始位置的列
        int max = 0;//记录最大值
        int end = 0;//最大长度更新时，记录子串的结尾位置
        while (row < chs1.length) {
            int i = row;
            int j = col;
            int len = 0;
            //从（i，j）开始向右下方遍历
            while (i < chs1.length && j < chs2.length) {
                if (chs1[i] != chs2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                if (len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        String str1 = "ABC1234567DEFG";
        String str2 = "HIJKL1234567MNOP";
        System.out.println(lcst1(str1, str2));
        System.out.println(lcst2(str1, str2));

    }
}
