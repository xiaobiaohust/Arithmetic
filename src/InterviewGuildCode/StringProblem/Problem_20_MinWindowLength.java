package InterviewGuildCode.StringProblem;

import java.util.LinkedList;

/**
 * 最小包含子串的长度
 * 给定字符串str1和str2，求str1的子串中含有str2所有字符的最小子串长度
 * 要求：str1的长度为N，时间复杂度为O(N)
 *
 * 思想：
 * 方法一；暴力解法，对每一个子串，判断是否包含str2所有字符
 * 方法二：
 * 1、使用两个指针，left、right分别表示子串的左右边界，从左开始，right向右延伸，当子串包含时，此刻是以left为起点的子串，且包含str2的最小子串
 * 2、left+1,重复上述，直到遍历结束，求出最小值
 * 3、需要一个map来维护str1子串的字符统计数据，来比较是否和str2的map一样。最终是由一个map和match变量来维护
 *

 */
public class Problem_20_MinWindowLength {
    public static int minLength(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chs2.length; ++i) {
            map[chs2[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = chs2.length;
        int minLength = Integer.MAX_VALUE;
        while (right < chs1.length) {
            map[chs1[right]]--;
            if (map[chs1[right]] >= 0) {
                match--;
            }
            if(match==0){
                while (map[chs1[left]]<0){
                    map[chs1[left++]]++;
                }
                minLength = Math.min(minLength,right-left+1);
                map[chs1[left++]]++;
                match++;
            }
            right++;
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
    public static void main(String[] args) {
        String str1 = "adabbca";
        String str2 = "acb";
        System.out.println(minLength(str1, str2));
    }
}
