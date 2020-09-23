package InterviewGuildCode.ArrayAndMatrix;

/**
 * 数组中未出现的最小正整数
 * 给定一个无序整形数组arr，找到数组中未出现的最小正整数
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 * 思路：
 * 1：题目要求是找到最小正整数，数组长度为N，理想情况下，数组元素不重复，
 * 从1到N，则最小为N+1，若有小于1，或者大于N，或者有重复的，则最小值一定在
 * 1到N中
 * 2：将数组每个数放在对应的位置上去，1<=arr[i]<=N,放置在位置arr[i]-1
 * 3：不是该范围的元素，全部放在最后
 *
 */
public class Problem_25_SmallestMissNum {
    public static int missNum(int[]arr){
        int l=0;
        int r = arr.length-1;
        while (l<=r){
            if(arr[l]<=0||arr[l]>r+1){
               arr[l] = arr[r--];
            }else if(arr[l]==l+1){
                l++;
            }else{
                swap(arr,l,arr[l]-1);
            }
        }
        return l+1;
    }
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 2, 1, 3, 5 };
        System.out.println(missNum(arr));

    }
}
