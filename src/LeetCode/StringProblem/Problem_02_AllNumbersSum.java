package LeetCode.StringProblem;

/**
 * 字符串中数字子串的求和
 * 要求：时间复杂度O(N)，空间复杂度O(1)
 */
public class Problem_02_AllNumbersSum {
    public static int numSum(String str) {
        if (str == null) {
            return 0;
        }
        char[] chs = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean flag = true;
        char cur = 0;
        for (int i = 0; i < chs.length; ++i) {
            cur = chs[i];
            if ('0' <= cur && cur <= '9') {
                num = num * 10 + cur - '0';
            } else {
                res = res + (flag == true ? num : -num);
                num = 0;
                if (cur == '-') {
                    if(i-1>-1&&chs[i-1]=='-'){
                        flag = !flag;
                    }else{
                        flag = false;
                    }
                }
                else{
                    flag = true;
                }
            }
        }
        res = res + (flag == true ? num : -num);
        return res;
    }


    public static void main(String[] args) {
        String test = "1K-100ABC500D-T--100F200G!!100H---300";
        System.out.println(numSum(test));
    }
}
