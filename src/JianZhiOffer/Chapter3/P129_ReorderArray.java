package JianZhiOffer.Chapter3;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 使用双指针，有点类似快排的partition
 */
public class P129_ReorderArray {
    public static void reorder(int[]arr){
        if(arr==null||arr.length==1){
            return;
        }
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            while (left<right&&(arr[left]&1)==1){
                left++;
            }
            while (left<right&&(arr[right]&1)==0){
                right--;
            }
            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[] data = {1,2,3,4,5,7,7};
        reorder(data);
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
            System.out.print('\t');
        }
        System.out.println();
    }
}
