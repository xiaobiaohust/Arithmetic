package LeetCode.BitOperation;

/**
 * 在其他数都出现偶数次的数组中找到出现奇数次的数
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 */
public class Problem_05_EvenTimesOddTimes {
    /**
     * 整数n与0异或的结果是n,整数n与整数n异或的结果是0，异或运算满足交换律
     * 遍历数组异或
     */

    public static void printOddTimesNum1(int[] arr) {
        int eO = 0;
        for (int cur : arr) {
            eO ^= cur;
        }
        System.out.println(eO);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eO = 0, eOhasOne = 0;
        for (int curNum : arr) {
            eO ^= curNum;
        }
        int rightOne = eO & (~eO + 1);
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {
                eOhasOne ^= cur;
            }
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

    }
}
