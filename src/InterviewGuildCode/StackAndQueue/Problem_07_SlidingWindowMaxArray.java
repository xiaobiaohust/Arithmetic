package InterviewGuildCode.StackAndQueue;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 有一个数组arr和一个大小为w的窗口，从左到右滑动，每次取窗口中的最大值，生成一个最大值数组
 * <p>
 * 思路1：暴力解法，时间复杂度O(NlogW)
 * 思路2：核心是记录前一个窗口的数据，并且动态更新数据；然后将该窗口中的数据
 * 进行压缩，如果该窗口中某个位置的数据比前面的要大，则前面的数据对于后面
 * 计算最大值是没有作用的，可以直接不管，但是如果小于等于前面的数呢，则有可能
 * 是后面窗口的最大值。
 * 1：使用一个双端队列记录前面窗口中的数据，记录的是arr的索引
 * 2：假设遍历arr到arr[i]，
 * 如果双端队列为空，直接将i放入队尾
 * 队列不为空，队尾元素为j，如果arr[i]<=arr[j],直接将i放入队尾
 * 队列不为空，队尾元素为j，如果arr[i]>arr[j],则arr[j]不能作为后面
 * 窗口的最大值，pop出去，在循环判断，直到队里为空或者arr[i]<=arr[j]
 * <p>
 * 可以得到队列也是一个有序数组，头最大，再看头对应的索引是否超出窗口范围
 * ，超过则对头pop
 */
public class Problem_07_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || w > arr.length) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; ++i) {
            while (!qmax.isEmpty() && arr[i] >= arr[qmax.peekLast()]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (i - qmax.peekFirst() >= w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        printArray(getMaxWindow(arr, w));
    }
}
