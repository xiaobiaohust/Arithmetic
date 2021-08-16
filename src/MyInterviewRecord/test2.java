package MyInterviewRecord;

public class test2 {
    public static int[] partition(int[]arr,int l,int r){
        int left =l-1;
        int right = r;
        while (l<right){
            if(arr[l]<arr[r]){
                swap(arr,++left,l++);
                left++;
                l++;
            }else if(arr[l]>arr[r]){
                swap(arr,l,--right);
            }else{
                l++;
            }
        }
        swap(arr,right,r);
        return new int[]{left+1,right};
    }
    public static void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
