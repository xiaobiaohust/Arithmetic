package InterviewGuildCode.StringProblem;

/**
 * 判断两个字符串是否互为变形词
 * 给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符
 * 出现的次数也一样，称str1和str2互为变形词
 * <p>
 * 方法一：假设字符的编码值为0~255，可以申请一个长度为256的整形数组map，
 * 用来统计每个字符出现的次数，map其实就是词频统计
 */
public class Problem_01_IsDeformation {
    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chs1.length; ++i) {
            map[chs1[i]]++;
        }
        for (int i = 0; i < chs2.length; ++i) {
            if (map[chs2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String A = "abcabcabc";
        String B = "bcacbaacb";
        System.out.println(isDeformation(A, B));

    }
}
