package LeetCode.StringProblem;

/**
 * 最小包含子串的长度
 * 给定字符串str1和str2，求str1的子串中含有str2所有字符的最小子串长度
 * 要求：str1的长度为N，时间复杂度为O(N)
 *
 * 思想：
 * 1：使用几个map来存储str2的分布，也就是子串需要满足的每个字符串的数量
 * 2：从左到右遍历str1，
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
