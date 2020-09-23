package InterviewGuildCode.ArrayAndMatrix;

import java.util.Arrays;

/**
 * 打印N个数组整体最大的top K
 * 有N个长度不一的数组，所有的数组都是有序的，从大到小打印N个数组整体最大的
 * 前K个数
 * 要求时间复杂度O(KlogN)
 * 思路：
 * 1：构建一个大小为N的大根堆，利用每个数组的最后一个元素。
 * 2：堆顶元素就是最大值，打印，同时将对应数组的下一个元素放在头部，调整堆，
 * 对应数组不存在元素，则将堆最后的一个元素放在头部,调整最大堆
 * 3：重复上述步骤，直到打印K个数，或者不存在数了
 *
 * 题目对空间复杂度没有要求，因此可以定义一个结构，存储对应的数组的相关信息
 */
public class Problem_20_PrintMaxTopK {
    public static class HeapNode {
        public int value; // 值是什么
        public int arrNum; // 来自哪个数组
        public int index; // 来自数组的哪个位置

        public HeapNode(int value, int arrNum, int index) {
            this.value = value;
            this.arrNum = arrNum;
            this.index = index;
        }
    }
    public static void printTopK(int[][]m,int topK){
        int heapSize = m.length;
        HeapNode[]heap = new HeapNode[heapSize];
        // 构建最大堆
        for(int i=0;i<heapSize;++i){
            int index = m[i].length-1;
            heap[i] = new HeapNode(m[i][m[i].length-1],i,m[i].length-1);
            heapInsert(heap,i);
        }
        System.out.println("开始：");
        for(int i=0;i<topK;++i){
            // 所有的数都不够topK,其实也可以在最外层做判断
            if(heapSize==0){
                break;
            }
            System.out.println(heap[0].value);
            if(heap[0].index!=0){
                heap[0].value = m[heap[0].arrNum][--heap[0].index];
            }else{
                swap(heap,0,--heapSize);
            }
            heapify(heap,0,heapSize);
        }
    }
    //构建最大堆
    public static void  heapInsert(HeapNode[]heap,int index){
        while(index!=0){
            int parent = (index-1)/2;
            if(heap[parent].value <heap[index].value){
                swap(heap,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }
    //从index开始向下调整最大堆
    public static void heapify(HeapNode[]heap,int index,int heapSize){
        int left = index*2+1;
        int right = index*2+1;
        int largest = index;
        while (left<heapSize){
            if(heap[left].value>heap[largest].value){
                largest = left;
            }if(heap[right].value>heap[largest].value){
                largest = right;
            }
            if(largest == index){
                break;
            }else{
                swap(heap,index,largest);
            }
            index = largest;
            left = index*2+1;
            right = index*2+2;
        }

    }

    public static void swap(HeapNode[] heap, int index1, int index2) {
        HeapNode tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    public static int[][] generateRandomMatrix(int maxRow, int maxCol,
                                               int maxValue) {
        if (maxRow < 0 || maxCol < 0) {
            return null;
        }
        int[][] matrix = new int[(int) (Math.random() * maxRow) + 1][];
        for (int i = 0; i != matrix.length; i++) {
            matrix[i] = new int[(int) (Math.random() * maxCol) + 1];
            for (int j = 0; j != matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * maxValue);
            }
            Arrays.sort(matrix[i]);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(5, 10, 1000);
        printMatrix(matrix);
        System.out.println("===========================");
        printTopK(matrix, 10);
    }
}
