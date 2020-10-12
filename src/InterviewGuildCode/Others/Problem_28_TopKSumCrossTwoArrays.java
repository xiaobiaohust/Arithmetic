package InterviewGuildCode.Others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 两个有序数组间相加和的TOP K问题
 * 给定两个有序数组arr1，arr2，在给定一个整数K，返回来自arr1和arr2的两个
 * 数相加和最大的前K个数，
 * 要求：时间复杂度O(KlogK)
 * 思路：对时间复杂度没有要求，一般可以使用最大堆解决topK问题
 * 1：分别将两个数组作为行，列，可以统计出所有的和矩阵
 * 2：从右下角开始，放入最大堆，调整，pop最大元素，记为（i,j）
 * 3：将（i-1,j）,(i,j-1)放入最大堆，继续调整
 */
public class Problem_28_TopKSumCrossTwoArrays {
    public static class HeapNode {
        public int row;
        public int col;
        public int value;

        public HeapNode(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public static int[] topKSum(int[] a1, int[] a2, int k) {
        if (a1 == null || a2 == null || k < 1) {
            return null;
        }
        k = Math.min(k, a1.length * a2.length);
        HeapNode[] heap = new HeapNode[k + 1];
        int heapSize = 0;
        int headR = a1.length - 1;
        int headC = a2.length - 1;
        int LR = -1;
        int LC = -1;
        int UR = -1;
        int UC = -1;
        int[] res = new int[k];
        int resIndex = 0;
        heapInsert(heap, heapSize++, headR, headC, a1[headR] + a2[headC]);
        HashSet<String> positionSet = new HashSet<>();
        while (resIndex < k) {
            HeapNode head = heap[0];
            swap(heap, 0, heapSize - 1);
            heap[--heapSize] = null;
            heapify(heap, 0, heapSize);

            res[resIndex++] = head.value;

            UR = head.row - 1;
            UC = head.col;
            if (UR > -1 && !positionSet.contains(UR + "_" + UC)) {
                heapInsert(heap, heapSize++, UR, UC, a1[UR] + a2[UC]);
                positionSet.add(UR + "_" + UC);
            }

            LR = head.row;
            LC = head.col - 1;
            if (LC > -1 && !positionSet.contains(LR + "_" + LC)) {
                heapInsert(heap, heapSize++, LR, LC, a1[LR] + a2[LC]);
                positionSet.add(LR + "_" + LC);
            }
        }
        return res;
    }

    public static void swap(HeapNode[] heap, int index1, int index2) {
        HeapNode tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    // 最大堆插入元素，从下往上调整
    public static void heapInsert(HeapNode[] heap, int index, int row, int col, int value) {
        heap[index] = new HeapNode(row, col, value);
        int parent = (index - 1) / 2;
        while (index != 0) {
            if (heap[parent].value < heap[index].value) {
                swap(heap, parent, index);
                index = parent;
                parent = (index - 1) / 2;
            } else {
                break;
            }
        }
    }

    //最大堆pop元素，将最前面和最后面一个元素交换，从上往下调整
    public static void heapify(HeapNode[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (heap[left].value > heap[largest].value) {
                largest = left;
            }
            if (right < heapSize && heap[right].value > heap[largest].value) {
                largest = right;
            }
            if (largest != index) {
                swap(heap, index, largest);
                index = largest;
                left = index * 2 + 1;
                right = index * 2 + 2;
            } else {
                break;
            }
        }
    }

    // For test, this method is inefficient but absolutely right
    public static int[] topKSumTest(int[] arr1, int[] arr2, int topK) {
        int[] all = new int[arr1.length * arr2.length];
        int index = 0;
        for (int i = 0; i != arr1.length; i++) {
            for (int j = 0; j != arr2.length; j++) {
                all[index++] = arr1[i] + arr2[j];
            }
        }
        Arrays.sort(all);
        int[] res = new int[Math.min(topK, all.length)];
        index = all.length - 1;
        for (int i = 0; i != res.length; i++) {
            res[i] = all[index--];
        }
        return res;
    }

    public static int[] generateRandomSortArray(int len) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * 100) + 1;
        }
        Arrays.sort(res);
        return res;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i != arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a1Len = 100;
        int a2Len = 100;
        int k = 80;
        int[] arr1 = generateRandomSortArray(a1Len);
        int[] arr2 = generateRandomSortArray(a2Len);
     /*   int[] arr1 = {19,40,41,41,44,55,59,81,85,88};
        int[] arr2 = {8,14,29,37,41,44,48,62,69,99}*/;
        printArray(arr1);
        printArray(arr2);
        long start = System.currentTimeMillis();
        int[] absolutelyRight = topKSumTest(arr1, arr2, k);
        printArray(absolutelyRight);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

        start = System.currentTimeMillis();
        int[] res = topKSum(arr1, arr2, k);
        printArray(res);
        end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

        System.out.println(isEqual(res, absolutelyRight));

    }
}
