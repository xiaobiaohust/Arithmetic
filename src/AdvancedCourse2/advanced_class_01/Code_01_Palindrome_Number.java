package AdvancedCourse2.advanced_class_01;


/**
 * 判断一个整数是否是回文数
 * 方法一：将整数转换为字符串，在判断字符串是否是回文串
 * 方法二：
 */
public class Code_01_Palindrome_Number {

	public static boolean isPalindrome(int n) {
		if (n < 0) {
			return false;
		}
		int help = 1;
		while (n / help >= 10) {
			help *= 10;
		}
		while (n != 0) {
			if (n / help != n % 10) {
				return false;
			}
			n = (n % help) / 10;// 去掉最前最后一个数得到的数
			help /= 100; //去掉前后两个数之后的最高位
		}
		return true;
	}

}
