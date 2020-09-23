package InterviewGuildCode.ArrayAndMatrix;

/**
 *奇数下标都是奇数或者偶数下标都是偶数
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 * 思路：
 * 1：设置变量even，表示当前arr最左边的偶数下标，初始值 0
 * 2：设置变量odd，表示当前arr最左边的奇数下标，初始值为1
 * 3：不断检查最后一个数，arr[N-1]，偶数则和arr[even]交换，even+=2，奇数则和arr[odd]
 * 交换，odd+=2.不断重复该步骤，直到even或者odd大于或等于N。
 *
 */
public class Problem_15_EvenInEvenOddInOdd {
    public static void modify(int[]arr){
        if(arr==null||arr.length==0){
            return;
        }
        int even  =0;
        int odd = 1;
        int end = arr.length-1;
        while (even<=end&&odd<=end){
            if((arr[end]&1)==1){
                swap(arr,odd,end);
                odd+=2;
            }else{
                swap(arr,even,end);
                even+=2;
            }
        }
    }
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 3, 2, 4, 6 };
        printArray(arr);
        modify(arr);
        printArray(arr);

    }
}
