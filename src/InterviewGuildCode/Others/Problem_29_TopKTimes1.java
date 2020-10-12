package InterviewGuildCode.Others;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 出现次数TOP K问题
 * 给定String类型的数组str，在给定整数k,按照排名顺序打印出现次数前K名的字符串
 * 要求：时间复杂度为O(NlogK)
 * 思路：遍历一遍，得到每个字符串的频率，时间复杂度O(N)，然后如果使用排序
 * ，则时间复杂度O(NlogN)，不满足要求。可以使用哈希表记录字符串及对应的
 * 频率，然后建立最小堆，时间复杂度O(NlogK)。最小堆的好处是，每次可以把
 * 最小的给替换掉，最后剩下的就是最大的K个
 */
public class Problem_29_TopKTimes1 {
    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static void printTopKAndRank(String[] arr, int k) {
        if (arr == null || k < 1) {
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            String cur = arr[i];
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        //遍历哈希表，建立最小堆
        Node[] heap = new Node[k];
        int index = 0;
        for (String key : map.keySet()) {
            int times = map.get(key);
            Node node = new Node(key, times);
            if (index < k) {
                heap[index] = node;
                heapInsert(heap,index++);
            }else {
                if(heap[0].times<node.times){
                    heap[0] = node;
                    heapify(heap,0,k);
                }
            }
        }
        //小根堆进行排序
        for(int i=index-1;i!=0;i--){
            swap(heap,0,i);
            heapify(heap,0,i);
        }
        // 严格按照排名打印k条记录
        for (int i = 0; i != heap.length; i++) {
            if (heap[i] == null) {
                break;
            } else {
                System.out.print("No." + (i + 1) + ": ");
                System.out.print(heap[i].str + ", times: ");
                System.out.println(heap[i].times);
            }
        }

    }

    public static void swap(Node[] heap, int index1, int index2) {
        Node tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    public static void heapInsert(Node[] heap, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[index].times < heap[parent].times) {
                swap(heap, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(Node[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize) {
            if (heap[left].times < heap[smallest].times) {
                smallest = left;
            }
            if (right < heapSize && heap[right].times < heap[smallest].times) {
                smallest = right;
            }
            if (smallest != index) {
                swap(heap, index, smallest);
                index = smallest;
                left = index * 2 + 1;
                right = index * 2 + 2;
            } else {
                break;
            }
        }
    }

    public static String[] generateRandomArray(int len, int max) {
        String[] res = new String[len];
        for (int i = 0; i != len; i++) {
            res[i] = String.valueOf((int) (Math.random() * (max + 1)));
        }
        return res;
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] arr = generateRandomArray(50, 10);
        int topK = 3;
        printArray(arr);
        printTopKAndRank(arr, topK);

    }
}
