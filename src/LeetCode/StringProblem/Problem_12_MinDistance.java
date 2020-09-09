package LeetCode.StringProblem;

/**
 * 数组中两个字符串的最小距离
 * 给定一个字符串数组strs，在给定两个字符串str1和str2，返回在strs中str1与
 * str2的最小距离，如果str1或str2为null或者不在strs当中，返回-1。
 */
public class Problem_12_MinDistance {
    public static int minDistance(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i].equals(str1)) {
                minValue = Math.min(minValue, last2 == -1 ? minValue : i - last2);
                last1 = i;
            }
            if (strs[i].equals(last2)) {
                minValue = Math.min(minValue, last1 == -1 ? minValue : i - last1);
                last2 = i;
            }
        }
        return minValue==Integer.MAX_VALUE?-1:minValue;
    }

    /**
     * 进阶题目
     * 如果查询发生的次数有很多，如何把每次查询的时间复杂度降为O(1)
     * 多次查询，时间复杂度为O(1)，可以使用哈希表存储结果
     * @param args
     */

    public static void main(String[] args) {
        String[] strArr = new String[] { "4", "2", "2", "3", "2", "2", "3",
                "1", "1", "3" };
        System.out.println(minDistance(strArr, "4", "3"));
        System.out.println(minDistance(strArr, "2", "3"));
        System.out.println(minDistance(strArr, "2", "1"));

        System.out.println("=======");


    }
}

