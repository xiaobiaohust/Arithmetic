package JianZhiOffer.Chapter2;

/**
 * 机器人的运动范围
 * 使用回溯法
 * 思路：
 *  机器人从（0,0）位置运动，只能上下左右运动，在满足特定条件下能够运动的范围。这种都有一个套路
 *  1、深度优先遍历，从开始节点的上下左右，选择一个节点，该节点满足条件，继续对它的上下左右节点进行遍历。
 *  2、需要一个visited数组，记录那些节点以及访问过
 *  3、需要判断每个节点是否满足条件，判断条件放在开始，这样就能只管进入，进去之后在判断是否满足条件
 */
public class P92_RobotMove {
    public static int movingCount(int threshold, int rowlen, int collen) {
        boolean[][] visited = new boolean[rowlen][collen];
        return process(threshold, rowlen, collen, 0, 0, visited);
    }

    public static int process(int threshold, int rowlen, int collen, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rowlen, collen, row, col, visited)) {
            visited[row][col] = true;//只是记录已经访问的格子，无需在还原状态
            count += 1 + process(threshold, rowlen, collen, row - 1, col, visited) + process(threshold, rowlen, collen, row + 1, col, visited)
                    + process(threshold, rowlen, collen, row, col - 1, visited) + process(threshold, rowlen, collen, row, col + 1, visited);
        }
        return count;

    }

    public static boolean check(int threshold, int rowlen, int collen, int row, int col, boolean[][] visited) {
        return row >= 0 && row < rowlen && col >= 0 && col < collen && !visited[row][col] && getDigitSum(row) + getDigitSum(col) <= threshold;

    }

    public static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(0, 3, 4)); //1
        System.out.println(movingCount(1, 3, 4)); //3
        System.out.println(movingCount(9, 2, 20)); //36
    }
}
