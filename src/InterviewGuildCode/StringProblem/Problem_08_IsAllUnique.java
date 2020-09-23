package InterviewGuildCode.StringProblem;

import java.util.HashSet;

/**
 * 判断字符数组中是否所有的字符都只出现过一次
 * 要求：
 * 1：要求时间复杂度为O(N)
 * 2：在额外空间复杂度为O(1)的前提下，时间复杂度尽量低
 */
public class Problem_08_IsAllUnique {
    /**
     * 方法一：使用map，map可以是数组或者哈希表
     */
    public static boolean isUnique1(char[] chs) {
        if (chs == null) {
            return true;
        }
        boolean[] map = new boolean[256];
        for (int i = 0; i < chs.length; ++i) {
            if (map[chs[i]]) {
                return false;
            }
            map[chs[i]] = true;
        }
        return true;
    }
    public static boolean isUnique2(char[]chs){
        if(chs==null){
            return true;
        }
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<chs.length;++i){
            if(set.contains(chs[i])){
                return false;
            }
            set.add(chs[i]);
        }
        return true;
    }

    /**
     * 额外空间复杂度O(1)
     * 思想是先排序，排序后相同字符放在一起
     * 1：时间复杂度为O(N)的排序算法，满足不了空间复杂度的要求
     *      桶排序、基数排序、计数排序
     * 2：时间复杂度为O(NlogN)的排序算法，只要堆排序满足空间复杂度要求
     *      归并排序、快速排序、希尔排序、堆排序
     * 3：堆排序的递归实现空间复杂度O(logN)，需要使用非递归实现
     * @param chas
     * @return
     */
    public static boolean isUnique3(char[]chas){
        if (chas == null) {
            return true;
        }
        heapSort(chas);
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == chas[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void heapSort(char[] chas) {
        for (int i = 0; i < chas.length; i++) {
            heapInsert(chas, i);
        }
        for (int i = chas.length - 1; i > 0; i--) {
            swap(chas, 0, i);
            heapify(chas, 0, i);
        }
    }

    public static void heapInsert(char[] chas, int i) {
        int parent = 0;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (chas[parent] < chas[i]) {
                swap(chas, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(char[] chas, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while (left < size) {
            if (chas[left] > chas[i]) {
                largest = left;
            }
            if (right < size && chas[right] > chas[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(chas, largest, i);
            } else {
                break;
            }
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    public static void swap(char[] chas, int index1, int index2) {
        char tmp = chas[index1];
        chas[index1] = chas[index2];
        chas[index2] = tmp;
    }


    public static void main(String[] args) {
        char[] chas = { '1', '2', '3', 'a', 'b', 'c', 'd', '4', '5', '6' };
        System.out.println(isUnique1(chas));
        System.out.println(isUnique2(chas));
        System.out.println(isUnique3(chas));

    }

}
