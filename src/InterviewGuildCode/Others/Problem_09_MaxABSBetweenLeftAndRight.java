package InterviewGuildCode.Others;

/**
 * 左边子数组最大值与右边子数组最大值之差的最大绝对值
 * 思路1：暴力解法，时间复杂度O(N^2)，额外空间复杂度O(1)
 *      遍历每个划分，求出左右最大值
 *
 * 思路2：时间复杂度O(N),额外空间复杂度O(N)
 * 1：先从左到右，在从右到左，记录到达每一个位置的最大值，通过
 * 这种方式能快速知道左右两边子数组的最大值
 *
 * 思路3：时间复杂度O(N)，额外空间复杂度O(1)
 * 1：求整个数组最大值，最大值要不在左边子数组，要不在右边子数组，
 * 2：假设在左边，右边子数组的最大值一定会大于等于最后一个数，所以
 * 右边子数组的最大值中的最小值就是最后一个数
 * 3：同理，假设在右边，左边子数组的最大值中的最小值就是第一个数
 */
public class Problem_09_MaxABSBetweenLeftAndRight {
    public static int maxABS1(int[]arr){
        int res = Integer.MIN_VALUE;
        int maxleft = Integer.MIN_VALUE;
        int maxright = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;++i){
            maxleft = Integer.MIN_VALUE;
            for(int j=0;j<i+1;++j){
                maxleft = Math.max(maxleft,arr[j]);
            }
            maxright = Integer.MIN_VALUE;
            for(int j=i+1;j<arr.length;++j){
                maxright = Math.max(maxright,arr[j]);
            }
            res = Math.max(res,Math.abs(maxleft-maxright));
        }
        return res;
    }

    public static int maxABS2(int[]arr){
        int[]larr = new int[arr.length];
        int[]rarr = new int[arr.length];
        int res = Integer.MIN_VALUE;
        larr[0] = arr[0];
        for(int i=1;i<arr.length;++i){
            larr[i] = Math.max(larr[i-1],arr[i]);
        }
        rarr[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>-1;--i){
            rarr[i] = Math.max(rarr[i+1],arr[i]);
        }
        for(int i=0;i<arr.length-1;++i){
            res = Math.max(res,Math.abs(larr[i]-rarr[i+1]));
        }
        return res;
    }

    public static int maxABS3(int[]arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;++i){
            max = Math.max(arr[i],max);
        }
        return max-Math.min(arr[0],arr[arr.length-1]);
    }

    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i != arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000) - 499;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = generateRandomArray(200);
        System.out.println(maxABS1(arr));
        System.out.println(maxABS2(arr));
        System.out.println(maxABS3(arr));
    }

}
