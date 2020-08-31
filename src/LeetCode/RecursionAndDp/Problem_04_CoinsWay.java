package LeetCode.RecursionAndDp;

/**
 * 换钱的方法数
 * 给定数组arr，arr为正数且不重复，每个值代表一种面值的货币，每种货币可以使用任意张，
 * 给定一个整数aim,求换钱aim有多少种方法
 */
public class Problem_04_CoinsWay {
    /**
     * 暴力递归
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
     * 记忆搜索，使用一个map，将结果存起来，就不需要重复计算
     */

    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);

    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {


    }

    public static void main(String[] args) {
        int[] coins = {10, 5, 1, 25};
        int aim = 2000;

        long start = 0;
        long end = 0;
        System.out.println("===========暴力递归的方法===========");
        start = System.currentTimeMillis();
        System.out.println(coins1(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");
    }


}

