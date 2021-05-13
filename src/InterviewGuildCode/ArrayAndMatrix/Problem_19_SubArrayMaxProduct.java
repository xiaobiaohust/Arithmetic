package InterviewGuildCode.ArrayAndMatrix;

/**
 * 数组中子数组的最大累积乘
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 * 思路：可以借鉴最大累积和的思路，但是由于有负数的乘法，所以在分别讨论
 * 会非常复杂
 * 1：求出以某个位置i-1结尾的最大累积乘max和最小累积乘min
 * 2：则i位置的最大累积乘有三种情况：
 *          max*arr[i]
 *          min*arr[i]
 *          arr[i]
 * 3：最大累积乘是上述三个最大一个，最小累积乘是上述最小一个
 * 上述方法有点想贪心算法
 */
public class Problem_19_SubArrayMaxProduct {
    public static double maxProduct(double[]arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        double res = arr[0];
        double max = arr[0];
        double min = arr[0];
        for(int i=1;i<arr.length;++i){
            double max_ = max*arr[i];
            double min_ = min*arr[i];
            max = Math.max(Math.max(max_,min_),arr[i]);
            min = Math.min(Math.min(max_,min_),arr[i]);
            res = Math.max(res,max);
        }
        return res;

    }

    public static void main(String[] args) {
        double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
        System.out.println(maxProduct(arr));

    }
}
