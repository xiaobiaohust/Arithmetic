package MyInterviewRecord;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1
 * 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class bilibil {
    public static int fun(int[]arr,int k){
        if(k<0){
            return -1;
        }
        if(k>=arr.length){
            return arr.length;
        }
        int maxlen = Integer.MIN_VALUE;
        int left = 0;
        int right= 0;
        int sum = arr[0];
        while(left<arr.length&&right<arr.length){
            if(sum+k>=right-left+1){
                maxlen = Math.max(maxlen,right-left+1);
                ++right;
                if(right<arr.length){
                    sum+=arr[right];
                }
            }else{
                sum-=arr[left++];
            }
        }
        return maxlen;
    }
    public static void main(String[]args){
        int[]arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(fun(arr,k));
    }
}
