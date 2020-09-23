package InterviewGuildCode.RecursionAndDp;

/**
 * 换钱的最少货币数
 * 题1：给定数组arr，arr为正数且不重复，每个值代表一种面值的货币，每种货币可以使用任意张，
 * 给定一个整数aim,求组成aim的最少货币数
 * 时间复杂度O(Nxaim),空间复杂度O(Nxaim),
 * 可以通过空间压缩的方式降低空间复杂度，时间O(Nxaim),空间O(aim)
 * <p>
 * 题2：给定数组arr，arr为正数，每个值仅代表一张钱的面值的，每种货币只能使用一次
 * 给定一个整数aim,求组成aim的最少货币数
 */
public class Problem_03_CoinsMin {

    /**
     * 题1：
     * 思想：arr长度为N,生成行数为N，列数为aim+1的动态规划表dp,dp[i][j]
     * 表示可以任意使用arr[0：i]的货币，组成j所需要的最小张数
     * dp[i][j] = min{dp[i-1][j],dp[i][j-arr[i]+1},如果j<arr[i],则越界了
     */
    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; ++j) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }

        int left = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max) {
                dp[j] = dp[j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }

    /**
     * 题2：
     * 思想：arr长度为N,生成行数为N，列数为aim+1的动态规划表dp,dp[i][j]
     * 表示可以任意使用arr[0：i]的货币，组成j所需要的最小张数，每张只能使用一次，
     * dp[i][j] = min{dp[i-1][j],dp[i-1][j-arr[i]]+1},如果j<arr[i],则越界了
     */

    public static int minCoins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        final int MAX = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int i = 1; i < aim + 1; ++i) {
            dp[0][i] = MAX;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        int left = MAX;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < aim + 1; ++j) {
                left = MAX;
                if(j-arr[i]>=0&&dp[i-1][j-arr[i]]!=MAX){
                    left =dp[i-1][j-arr[i]]+1;
                }
                dp[i][j] =Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim]!=MAX?dp[n-1][aim]:-1;


    }

    public static int minCoins4(int[]arr,int aim){
        if(arr==null||arr.length==0||aim<0){
            return -1;
        }
        int n = arr.length;
        final int MAX = Integer.MAX_VALUE;
        int[]dp = new int[aim+1];
        for(int i=1;i<aim+1;++i){
            dp[i] = MAX;
        }
        if(arr[0]<=aim){
            dp[arr[0]]=1;
        }
        int left;
        for(int i=1;i<n;++i){
            //必须从后往前，要不然前面的会被替换
            for(int j=aim;j>0;j--){
                left= MAX;
                if(j-arr[i]>=0&&dp[j-arr[i]]!=MAX){
                    left = dp[j-arr[i]]+1;
                }
                dp[j] = Math.min(left,dp[j]);
            }
        }
        return dp[aim]!=MAX?dp[aim]:-1;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 20, 5, 10, 2, 50, 1};
        int aim1 = 17019;
        System.out.println(minCoins1(arr1, aim1));
        System.out.println(minCoins2(arr1, aim1));

        int[] arr2 = { 10, 100, 2, 5, 5, 5, 10, 1, 1, 1, 2, 100 };
        int aim2 = 223;
        System.out.println(minCoins3(arr2, aim2));
        System.out.println(minCoins4(arr2, aim2));


    }
}
