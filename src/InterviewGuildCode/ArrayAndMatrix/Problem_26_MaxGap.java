package InterviewGuildCode.ArrayAndMatrix;

/**
 * 数组排序之后相邻数的最大差值
 * 给定一个整形数组arr，返回排序之后相邻两数的最大差值
 * 要求：时间复杂度O(N)，额外空间复杂度O(N)
 * <p>
 * 思路：直接使用排序算法，时间复杂度O(NlogN)，利用桶排序的思想可以实现
 * 时间复杂度O(N)。额外空间复杂度O(N)
 * 思路：
 * 1：遍历数组找到最大值max，最小值min
 * 2：arr长度为N，准备N+1个桶，把max放在N+1号桶，将每个数放在一个桶里，
 * 每个桶负责的区间（max-min）/N ,一个数为num，桶号：(num-min)*N/(max-min)
 * 3：max一定会放在N+1号桶，必然有桶是空的，相邻两个数，必然出现在桶内或者桶
 * 间，桶内最大值为桶的宽度，由于必然会有空桶，所以相邻两个数最大值必然出现
 * 在桶间
 * 4：只需记录桶的最大值最小值，相邻最大值必然出现在桶的最小值，减去前面一个
 * 非空桶的最大值。
 */
public class Problem_26_MaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            int bid = (nums[i] - min) * len / (max - min);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = Integer.MIN_VALUE;
        int lastBid = 0;
        for(int i=1;i<len+1;++i){
            if(hasNum[i]){
                int gap = mins[i]-maxs[lastBid];
                res = Math.max(res,gap);
                lastBid = i;
            }
        }
    return res;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 10, 9, 3, 1, 12 };
        System.out.println(maxGap(arr));

    }
}
