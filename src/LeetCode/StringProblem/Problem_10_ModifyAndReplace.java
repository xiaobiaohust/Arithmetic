package LeetCode.StringProblem;

/**
 * 字符串的调整与替换
 * 给定一个字符类型的数组chas[]，chas右半区全是空字符，左半区域不含有空字符
 * 将左半区域中所有的空格字符替换成“%20”，假设chas右半区域足够大
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 * 方法：从左到右遍历，得到左半区域长度以及空格数，然后从右到左遍历填充
 */
public class Problem_10_ModifyAndReplace {
    public static void replace(char[] chs) {
        if (chs == null || chs.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        while (chs[len] != 0) {
            len++;
            if (chs[len] == ' ') {
                num++;
            }
        }
        int j = len + 2 * num - 1;
        for (int i = len - 1; i >= 0; --i) {
            if (chs[i] == ' ') {
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            } else {
                chs[j--] = chs[i];
            }
        }
    }

    /**
     * 补充题目
     * 给定一个字符类型的数组chs[]，只含有数字字符和* 字符，把所有的*挪到
     * chs的左边，数字字符挪到chs的右边
     * 要求：时间复杂度O(N)，空间复杂度O(1)
     * @param chs
     */
    public static void modify(char[]chs){
        if(chs==null||chs.length==0){
            return;
        }
        int j=chs.length-1;
        for(int i=chs.length-1;i>-1;--i){
            if(chs[i]!='*'){
                chs[j--] = chs[i];
            }
        }
        for(;j>-1;){
            chs[j--] = '*';
        }

    }

    public static void main(String[] args) {
        char[] chas1 = {'a', ' ', 'b', ' ', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0,};
        replace(chas1);
        System.out.println(String.valueOf(chas1));

        char[] chas2 = {'1', '2', '*', '*', '3', '4', '5'};
        modify(chas2);
        System.out.println(String.valueOf(chas2));

    }
}
