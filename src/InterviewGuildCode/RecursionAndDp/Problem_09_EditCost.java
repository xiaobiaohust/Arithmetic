package InterviewGuildCode.RecursionAndDp;

/**
 * 最小编辑代价
 * 给定两个字符串str1和str2，在给定三个整数ic、dc、rc分别代表插入、删除和替换
 * 一个字符的代价，返回将str1编辑成str2的最小代价
 * 要求：时间复杂度O(MxN)，额外空间复杂度O(MxN)
 */
public class Problem_09_EditCost {
    /**
     * 经典的动态规划可以实现时间复杂度O(MxN)，额外空间复杂度O(MxN)
     * 思想：dp[i][j]的值代表str[0~i-1]编辑成str2[0~j-1]的最小代价
     * dp[0][0]=0，表示空的子串编辑成空的子串代价为0
     * 1：第一行，插入元素，dp[0][j] = ic*j
     * 2：第一列，删除元素，dp[j][0] = dc*j
     * 3：其他位置dp[i][j],是以下四种情况中的最小值
     * dp[i-1][j]+dc
     * dp[i][j-1]+ic
     * str1[i]!=str2[j],dp[i-1][j-1]+rc
     * str1[i]=str2[j],dp[i-1][j-1]
     */

    public static int minCost1(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length + 1;
        int col = chs2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 1; i < col; ++i) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = chs1[i-1] == chs2[j-1] ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + rc;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+ic);
            }
        }
        return dp[row-1][col-1];
    }

    /**
     * 使用空间压缩的方法
     * @param str1
     * @param str2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    public static int minCost2(String str1,String str2,int ic,int dc,int rc){
        return 0;
    }

    public static void main(String[] args) {
        String str1 = "ab12cd3";
        String str2 = "abcdf";
        System.out.println(minCost1(str1, str2, 5, 3, 2));
        //System.out.println(minCost2(str1, str2, 5, 3, 2));

        str1 = "abcdf";
        str2 = "ab12cd3";
        System.out.println(minCost1(str1, str2, 3, 2, 4));
        //System.out.println(minCost2(str1, str2, 3, 2, 4));

        str1 = "";
        str2 = "ab12cd3";
        System.out.println(minCost1(str1, str2, 1, 7, 5));
        //System.out.println(minCost2(str1, str2, 1, 7, 5));

        str1 = "abcdf";
        str2 = "";
        System.out.println(minCost1(str1, str2, 2, 9, 8));
        //System.out.println(minCost2(str1, str2, 2, 9, 8));

    }

}
