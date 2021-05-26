package InterviewGuildCode.Others;

/**
 * 判断一个数是否是回文数
 * 方法一、
 * 1、将整数转为字符数组，左右指针向中间夹，判断是否是回文数
 *
 * 方法二、
 * 1、不转为字符串判断，而是直接得到整数的最高位和最低位的数字，在分别得到下一个位置的数
 */
public class Problem_18_PalindromeNumber {
    public static boolean isPalindrome(int n){
        if(n==Integer.MIN_VALUE){
            return false;
        }
        n = Math.abs(n);
        int help = 1;
        while (n/help>=10){
            help*=10;
        }
        while (n!=0){
            if(n/help!=n%10){
                return false;
            }
            n = (n%help)/10;
            help/=100;
        }
        return true;
    }

    public static void main(String[] args) {
        int test = -10001;
        System.out.println(isPalindrome(test));

    }
}
