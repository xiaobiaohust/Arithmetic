package InterviewGuildCode.RecursionAndDp;

/**
 * 换钱的方法数
 * 给定数组arr，arr为正数且不重复，每个值代表一种面值的货币，每种货币可以使用任意张，
 * 给定一个整数aim,求换钱aim有多少种方法
 */
public class Problem_04_CoinsWay {
    /**
     * 暴力递归,时间复杂度O(aim^N)
     * 思路：假设第一种货币使用0、1、2、3...次，用剩下的货币换省下钱，相加就是总方法，如此暴力递归计算，
     */
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; ++i) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    /**
     * 记忆搜索，使用一个map，将暴力递归的中间结果结果存起来，就不需要重复计算,
     * 时间复杂度O(N x aim^2)
     */

    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);

    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; ++i) {
                if (map[index + 1][aim - arr[index] * i] != 0) {
                    res += map[index + 1][aim - arr[index] * i];
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res;
        return res;

    }

    /**
     * 动态规划
     *思路：
     *      生成行数为N、列数为aim+1 的dp矩阵，dp[i][j]的含义是在使用arr[0:i]
     *   货币得情况下，组成钱数j有多少种方法
     *
     *   第一列全部是1，也就是组成钱数为0的方法数为1，不使用任何货币
     *   第一行，当钱数是arr[0]的倍数时候，为1，否则为0
     *   剩下位置记为dp[i][j],dp[i][j]由以下几个值累加
     *      *  使用0张arr[i]货币，方法数为dp[i-1][j]
     *      *  使用1张arr[i]货币，方法数为dp[i-1][j-arr[i]]
     *      *   ...
     *      *  使用K张arr[i]货币，方法数为dp[i-1][j-k*arr[i]]
     *    最终dp[N-1][aim]的值就是最终结果
     *复杂度：
     *      最坏情况下计算dp[i][j]需要枚举dp[i-1][0:j]上的所有位置，
     *      所以时间复杂度O(N x aim^2),空间复杂度O(N x aim)
     */

    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= aim; ++i) {
            dp[0][i * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j < aim + 1; ++j) {
                int res = 0;
                for (int k = 0; j - k * arr[i] >= 0; ++k) {
                    res += dp[i - 1][j - k * arr[i]];
                }
                dp[i][j] = res;
            }
        }
        return dp[arr.length - 1][aim];

    }

    /**
     * 动态规划的优化，
     * 时间复杂度O(N x aim),空间复杂度O(N x aim)
     * 思想：
     *      优化的是非第一列和第一行，第三层for循环累加值除了第一个之外，
     *      其结果就是dp[i][j-arr[i]]
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= aim; ++i) {
            dp[0][i * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < aim + 1; ++j) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length-1][aim];
    }

    /**
     * 动态规划的优化，时间复杂度O(N x aim),对空间进行压缩，空间复杂度O(aim)
     * 思想：优化的是非第一列和第一行，for循环累加值其实就是dp[i][j-arr[i]
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[]dp = new int[aim + 1];
        for (int i = 0; i * arr[0] <= aim; ++i) {
            dp[i * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < aim + 1; ++j) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }

    public static void main(String[] args) {
        int[] coins = {10, 5, 1, 25};
        int aim = 10000;

        long start = 0;
        long end = 0;
        System.out.println("===========暴力递归的方法===========");
        start = System.currentTimeMillis();
        //System.out.println(coins1(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        System.out.println("===========记忆搜索的方法===========");
        start = System.currentTimeMillis();
        System.out.println(coins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        System.out.println("=====动态规划O(N*(aim^2))的方法=====");
        start = System.currentTimeMillis();
        System.out.println(coins3(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        System.out.println("=======动态规划O(N*aim)的方法=======");
        start = System.currentTimeMillis();
        System.out.println(coins4(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        System.out.println("====动态规划O(N*aim)的方法+空间压缩===");
        start = System.currentTimeMillis();
        System.out.println(coins5(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");
    }


}

