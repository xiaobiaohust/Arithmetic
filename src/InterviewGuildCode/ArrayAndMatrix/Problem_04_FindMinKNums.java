package InterviewGuildCode.ArrayAndMatrix;

/**
 * 找到无序数组中最小的k个数
 * 方法一：排序之后求，时间复杂度O(NlogN)
 * 方法二：使用最大堆。
 * 1：维护一个含有k个数的大根堆，表示目前选出的最小的k个数，堆顶元素是堆中的最大元素。
 * 2：遍历数组，小于栈顶元素，则替换，然后调整整个堆
 *
 * 三：时间复杂度O(N)，BFPRT算法
 */
public class Problem_04_FindMinKNums {
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }

        int[] heap = new int[k];
        for (int i = 0; i < k; ++i) {
            heapInsert(heap, arr[i], i);
        }
        for(int i=k;i<arr.length;++i){
            if(arr[i]<heap[0]){
                heap[0] =arr[i];
                heapify(heap,0,k);
            }
        }
        return heap;
    }

    //建立最大堆的时候，插入元素，向上调整
    public static void heapInsert(int[] arr, int value, int index) {
        arr[index ] = value;
        while (index!=0){
            int parent = (index-1)/2;
            if(arr[parent]<arr[index]){
                swap(arr,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }

    // 向下调整堆
    public static void heapify(int[]arr,int index,int heapsize){
        int left = index*2+1;
        int right = index*2+1;
        int largest = index;
        while (left<heapsize){
            if(arr[left]>arr[largest]){
                largest = left;
            }
            if(right<heapsize&&arr[right]>arr[largest]){
                largest = right;
            }
            if(largest!=index){
                swap(arr,index,largest);
            }else{
                break;
            }
            index =  largest;
            left = index*2+1;
            right = index*2+2;
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
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getMinKNumsByHeap(arr, 10));
        //printArray(getMinKNumsByBFPRT(arr, 10));

    }
}
