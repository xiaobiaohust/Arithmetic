package InterviewGuildCode.Others;

/**
 * 求两个数的最大公约数
 * 思路：欧几里得算法（辗转相除法）
 * m,n的商和余数为别说q,r,m=nq+r，那么m和n的最大公约数等于n和r的最大
 * 公约数
 */
public class Problem_02_GCD {
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    public static void main(String[] args) {

        System.out.println(gcd(18, 1));

    }
}
