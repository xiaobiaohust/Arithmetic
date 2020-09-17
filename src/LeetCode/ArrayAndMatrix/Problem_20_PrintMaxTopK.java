package LeetCode.ArrayAndMatrix;

/**
 * 打印N个数组整体最大的top K
 * 有N个长度不一的数组，所有的数组都是有序的，从大到小打印N个数组整体最大的
 * 前K个数
 * 要求时间复杂度O(KlogN)
 * 思路：
 * 1：构建一个大小为N的大根堆，利用每个数组的最后一个元素。
 * 2：堆顶元素就是最大值，打印，同时将对应数组的下一个元素放在头部，调整堆，
 * 对应数组不存在元素，则将堆最后的一个元素放在头部
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
    }
    public static void
}
