package JianZhiOffer.Chapter3;

import net.mindview.util.Stack;

/**
 * 打印1到最大的n位数
 * 思路：需要考虑大数问题，在字符串上模拟数字加法
 */
public class P114_Print1ToMaxOfNDigits {
    public static void printnums(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder number = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            number.append('0');
        }
        while (increment(number)){
            printNumber(number );
        }
    }

    public static boolean increment(StringBuilder str) {
        int ci = 1;
        for (int i = str.length() - 1; i > -1; --i) {
            if (ci == 0) break;
            if (str.charAt(i) == '9') {
                str.setCharAt(i, '0');
                ci = 1;
            } else {
                str.setCharAt(i, (char) (str.charAt(i) + 1));
                ci = 0;
            }
            // 越界了
            if (i == 0 && ci == 1) return false;
        }
        return true;
    }
    public static void printNumber(StringBuilder number){
        boolean flag = false;
        int i=0;
        while (i<number.length()){
            if(flag){
                System.out.print(number.charAt(i++));
            }else if(number.charAt(i)!='0'){
                flag =true;
                System.out.print(number.charAt(i++));
            }else{
                i++;
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        printnums(4);
    }
}
