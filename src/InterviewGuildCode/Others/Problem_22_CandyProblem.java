package InterviewGuildCode.Others;

/**
 * 分糖果问题
 * 一群孩子做游戏，根据游戏得分来发糖果，每个孩子至少分到一棵糖果，任意两个
 * 孩子之间，得分较多的必须多拿一些糖果，返回最少需要多少糖果
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 */
public class Problem_22_CandyProblem {
    public static int candy1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 先开始来个右坡，之后总是一个左坡一个右坡
        int index = nextMinIndex1(arr, 0);
        int res = rightCands(arr, 0, index++);
        int lbase = 1;
        int next = 0;
        int rcands = 0;
        int rbase = 0;
        while (index != arr.length) {
            if (arr[index] > arr[index - 1]) {
                res += ++lbase;
                index++;
            } else if (arr[index] < arr[index - 1]) {
                next = nextMinIndex1(arr, index - 1);
                rcands = rightCands(arr, index - 1, next++);
                rbase = next - index + 1;
                res += rcands + (rbase > lbase ? -lbase : -rbase);
                lbase = 1;
                index = next;
            } else {
                res += 1;
                lbase = 1;
                index++;
            }
        }
        return res;
    }

    public static int nextMinIndex1(int[] arr, int start) {
        for (int i = start; i != arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public static int rightCands(int[] arr, int left, int right) {
        int n = right - left + 1;
        return n + n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        int[] test1 = { 3, 0, 5, 5, 4, 4, 0 };
        System.out.println(candy1(test1));

        int[] test2 = { 3, 0, 5, 5, 4, 4, 0 };
        //System.out.println(candy2(test2));
    }

}
