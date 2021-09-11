package MyInterviewRecord;

import java.util.Arrays;

public class bigo3 {
    public static void fun(int[]arr){
        int cur1 =-1;
        int cur2 = 0;
        while (cur2<arr.length){
            if(arr[cur2]!=0){
                arr[++cur1] = arr[cur2];
            }
            cur2++;
        }

        for(int i=cur1+1;i<arr.length;++i){
            arr[i] = 0;
        }
    }
    public static void main(String[]args){
        int[]arr = new int[]{-1,0,2,3,1,0};
        fun(arr);
        System.out.println(Arrays.toString(arr));
    }
}
