package LeetCode.RecursionAndDp;

/**
 * 跳跃游戏
 * 给定数组arr，arr[i]==k代表可以从位置i向右跳1~k个距离。从位置0出发，返回
 * 最少跳几次能跳到arr最后的位置，arr长度为N
 * 要求：时间复杂度O(N)，额外空间复杂度为O(1)
 */
public class Problem_15_JumpGame {
    public static int jump(int[]arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for(int i=0;i<arr.length;++i){
            if(cur<i){
                jump++;
                cur = next;
            }
            next = Math.max(next,i+arr[i]);
        }
        return jump;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 1, 1, 4 };
        System.out.println(jump(arr));

    }
}
