package InterviewGuildCode.RecursionAndDp;

/**
 * 龙与地下城游戏
 * 给定一个二维数组map，含义是一张地图，正数表示经过可以加血，负数需要减血
 * 每次只能向下或者向右，任何位置血量不少于1，为了能够到达右下角，初始血量
 * 至少是多少
 * <p>
 * 方法一：经典动态规划，定义矩阵dp，dp[i][j]表示要经过位置（i，j），并且从
 * 该位置选这一条最优路径到右下角，需要具备的最低血量
 * 1：最后一行，dp[M-1][j] = max(dp[M-1][j+1]-map[M-1][j],1)
 * 2：最后一列,dp[i][N-1] = max(dp[i][N-1]-map[i][N-1],1)
 * 3：其他位置，从下到上，从右到左dp[i][j],下面选最小值
 * max(dp[i][j+1]-map[i][j],1)
 * max(dp[i+1][j]-map[i][j],1)
 */
public class Problem_11_DungeonGame {
    /**
     * 时间复杂度O(MxN)，空间复杂度O(MxN)
     * @param map
     * @return
     */
    public static int minHP1(int[][] map) {
        if (map == null || map.length == 0 || map[0] == null || map[0].length == 0) {
            return 1;
        }
        int row = map.length;
        int col = map[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = map[row - 1][col - 1] > 0 ? 1 : -map[row - 1][col - 1] + 1;
        for (int j = row - 2; j >= 0; --j) {
            dp[row - 1][j] = Math.max(dp[row - 1][j + 1] - map[row - 1][j], 1);
        }
        for (int i = col - 2; i >= 0; --i) {
            dp[i][col - 1] = Math.max(dp[i + 1][col - 1] - map[i][col - 1], 1);
        }
        for (int i = row - 2; i >= 0; --i) {
            for (int j = col - 2; j >= 0; --j) {
                dp[i][j] = Math.min(Math.max(dp[i][j + 1] - map[i][j], 1),
                        Math.max(dp[i + 1][j] - map[i][j], 1));
            }
        }
        return dp[0][0];
    }

    /**
     * 采用空间压缩方法，时间复杂度O(MxN)，空间复杂度O(min(M,N))
     * @param m
     * @return
     */
    public static int minHP2(int[][] m) {
       return 0;
    }
    public static void main(String[] args) {
        int[][] map = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 }, };
        System.out.println(minHP1(map));
        System.out.println(minHP2(map));

    }
}
