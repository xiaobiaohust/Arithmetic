package JianZhiOffer.Chapter2;

/**
 * 旋转数组的最小数字
 * 二分查找
 * 1、数组没有重合元素，可以使用简单一点的方式。可以认为left指针总是指向左边的递增数组，
 * right指针总是指向后面的递增数组
 * * arr[mid]>arr[left]，则最小值在mid右边，left = mid
 * * arr[mid]<arr[right]，则最小值在mid左边。right = mid
 * <p>
 * 2、数组有重复元素
 * 和上述思路一致，只不过在等于的时候，又需要区分；以及跳出循环的条件不同
 * 1、
 */
public class P82_MinNumberInRotatedArray {
    public static int min(int[] data) {
        if (data == null || data.length == 0)
            return -1;
        int left = 0;
        int right = data.length - 1;
        int mid = left;
        while (left <= right) {
            //正常来说，left和right分别指向前后递增数组
            //当left和right相邻的时候，此时right就是最小值
            if (right - left <= 1) {
                mid = right;
                break;
            }
            //正常来说，left和right分别指向前后递增数组
            //当mid和left、right相等的时候，此时left和right都会移动，可能导致left、right指向
            //一个递增数组，此时只需返回left，退出就行
            if(data[left]<data[right]){
                mid = left;
                break;
            }
            mid = (right + left) / 2;
            if (data[mid] > data[left])
                left = mid;
            else if (data[mid] < data[left]) {
                right = mid;
            }
            else {
                if(data[mid] > data[right]){
                    left = mid;
                }else if(data[mid] < data[right]){
                    right = mid;
                }else{
                    left++;
                    right--;
                }
            }

        }
        return data[mid];
    }

    public static void main(String[] args) {
        int[] data1 = {3, 4, 5, 1, 2};
        int[] data2 = {1, 0, 1, 1, 1};
        int[] data3 = {1, 1, 1, 0, 1};
        int[] data4 = {1, 2, 3, 4, 5};
        System.out.println(min(data1));
        System.out.println(min(data2));
        System.out.println(min(data3));
        System.out.println(min(data4));
    }

}
