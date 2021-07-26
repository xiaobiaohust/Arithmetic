package JianZhiOffer.Chapter3;

/**
 * 正则表达式匹配
 * 模式中可以由'.'和'*'
 */
public class P124_RegularExpressionsMatching {
    public static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(String str, int strIndex, String pattern, int patternIndex) {
        // 递归退出条件
        if (strIndex == str.length() && patternIndex == pattern.length()) {
            return true;
        } else if (strIndex < str.length() && patternIndex == pattern.length()) {
            return false;
        } else if (strIndex == str.length() && patternIndex < pattern.length()) {
            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            } else
                return false;
        }

        //正常匹配
        if (patternIndex == pattern.length() - 1 || pattern.charAt(patternIndex + 1) != '*') {
            //pattern的下一个字符不是'*'或者pattern到达最后一个字符
            if (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.') {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            } else {
                return false;
            }
        } else {
            //pattern的下一个字符是'*'。'*'可以匹配不匹配，也可以匹配一次，也可以匹配多次
            if (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.') {
                return matchCore(str, strIndex, pattern, patternIndex + 2) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(match("aaa", "a.a"));//true
        System.out.println(match("aaa", "ab*ac*a"));//true
        System.out.println(match("aaa", "aa.a"));//false
        System.out.println(match("aaa", "ab*a"));//false
    }
}
