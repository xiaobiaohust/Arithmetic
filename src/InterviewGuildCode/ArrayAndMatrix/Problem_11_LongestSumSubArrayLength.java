package InterviewGuildCode.ArrayAndMatrix;

import java.util.HashMap;

/**
 * 未排序数组中累加和为给定值的最长子数组系列问题
 * 题1：给定一个无序数组arr，可正、负、0，给定一个整数k,求arr所有的子数组中累加
 * 和为k的最长子数组长度
 * 题2：。。。正数与负数个数相等的最长子数组
 *
 * 要求：时间复杂度O(N)，空间复杂度O(N)
 *
 * 思路1：
 * 1：遍历数组，求出以每个元素结尾，从最左边的累加和数组s
 * 2：在遍历的过程中，假设子数组以i结尾，则需要在数组s中寻找
 * 最左边的s[i]-k
 */
public class Problem_11_LongestSumSubArrayLength {
    public static int maxLength(int[]arr,int k){
        if(arr==null||arr.length==0){
            return 0;
        }
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);//非常特殊
        int len = 0;
        int sum = 0;
        for(int i=0;i<arr.length;++i){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                len=Math.max(len,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(maxLength(arr, 10));

    }
}
