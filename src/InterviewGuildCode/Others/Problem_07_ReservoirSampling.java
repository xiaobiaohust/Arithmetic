package InterviewGuildCode.Others;

/**
 * 蓄水池算法
 * 一个袋子最多只能装K个球，机器按照自然序列的方式吐出球
 * （1,2,3.。。），设计一种选择方式，使得当机器吐出第N号球的
 * 时候（N>K），袋子中的球数是K，同时1~N中的每一个球，被选中的
 * 概率都是K/N
 * <p>
 * 思路：
 * 1:1~K直接放入袋子中
 * 2：处理第i号球时（i>K），以k/i的概率决定是否将i号球放进袋子
 * ，如果放进去，则随机选择一个扔掉
 */
public class Problem_07_ReservoirSampling {
    public static int rand(int max) {
        return (int) (Math.random() * max) + 1;
    }

    public static int[] getKNumsRand(int k, int max) {
        if(max<1||k<1){
            return null;
        }
        int[] res = new int[Math.min(k,max)];
        for(int i=0;i<res.length;++i){
            res[i] = i+1;
        }
        for(int i=k+1;i<max+1;++i){
            if(rand(i)<=k){
                res[rand(k)-1] = i;
            }
        }
        return res;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] res = getKNumsRand(10, 10000);
        printArray(res);
    }
}
