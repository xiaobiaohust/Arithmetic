package JianZhiOffer.Chapter2;

/**
 * 剪绳子
 * 把长为n的绳子剪成m段，将m段绳子的长度进行乘积，求乘积最大
 */
public class P96_CuttingRope {
    //动态规划解决问题
    public static int maxCutting(int n) {
        if (n <= 1)
            return -1;
        if (n <= 3)
            return n - 1;
        // dp[i]表示长为i的绳子 剪或者不剪可以得到的最大乘积
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max;
        int temp;
        for (int i = 4; i < n+1; ++i) {
            max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                temp = dp[j] * dp[i - j];
                if (temp > max)
                    max = temp;
            }
            dp[i] = max;
        }
        return dp[n];

    }
    //还可以使用贪婪算法解决,把绳子全部剪成2或者3的长度
    //当n>=5时，尽可能剪成长度为3的绳子
    //当n=4时候，把绳子剪成两段长为2的绳子
    public static int maxCutting2(int n){
        if (n <= 1)
            return -1;
        if (n <= 3)
            return n - 1;




        int nums3 = n/3;
        if(n%3==1)
            nums3-=1;
        int nums2 = (n-nums3*3)/2;
        return (int)(Math.pow(3,nums3))*(int)(Math.pow(2,nums2));

    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            System.out.println("长度为" + i + "的最大值->" + maxCutting(i));
            System.out.println("长度为" + i + "的最大值->" + maxCutting2(i));
        }
    }

}
