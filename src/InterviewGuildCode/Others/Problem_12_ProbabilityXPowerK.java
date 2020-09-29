package InterviewGuildCode.Others;

/**
 * 调整[0,x]区间上的数出现的概率
 * 实现一个函数返回[0,1)上的数，但是在[0,x)出现的概率为想x^k
 * 思路：调用random函数K次，每次取最大值
 */
public class Problem_12_ProbabilityXPowerK {

    public static double randXPower2(){
        return Math.max(Math.random(),Math.random());
    }
    public static double randXPowerK(int k){
        if(k<1){
            return 0;
        }
        double res = Double.MIN_VALUE;
        for(int i=0;i<k;++i){
            res = Math.max(res,Math.random());
        }
        return res;
    }
    public static void main(String[] args) {
        double range = 0.5;
        int times = 5000000;
        int count = 0;
        for (int i = 0; i != times; i++) {
            if (randXPowerK(2) < range) {
                count++;
            }
        }
        double p = (double) count / (double) times;
        System.out.println("range [0," + range + "), probability: " + p);
    }
}
