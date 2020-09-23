package InterviewGuildCode.StringProblem;

import java.util.HashMap;

/**
 * 找到字符串的最长无重复字符子串
 * 要求：时间复杂度为O(N)
 * 思路：其实也是动态规划的问题，至少空间复杂度压缩了一下，使用了一个变量
 */
public class Problem_18_LongestNoRepeatSubstring {

    public static int maxUnique(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[] chs = str.toCharArray();
        HashMap<Character,Integer>map = new HashMap<>();
        int maxLen = 0;
        int pre = -1;
        for(int i=0;i<chs.length;i++){
            pre= Math.max(pre,map.containsKey(chs[i])?map.get(chs[i]):-1);
            maxLen = Math.max(maxLen,i-pre);
            map.put(chs[i],i);
        }
        return maxLen;
    }

    // for test
    public static String getRandomString(int len) {
        char[] str = new char[len];
        int base = 'a';
        int range = 'z' - 'a' + 1;
        for (int i = 0; i != len; i++) {
            str[i] = (char) ((int) (Math.random() * range) + base);
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        String str = getRandomString(20);
        System.out.println(str);
        System.out.println(maxUnique(str));

    }
}
