package InterviewGuildCode.Others;

public class Problem_01_Rand5ToRand7 {
    /**
     * 一、原问题
     * 1、rand5：随机产生1,2,3,4,5
     * 2、rand5-1：随机产生0,1,2,3,4
     * 3、(rand5-1)*5：随机产生0,5,10,15,20
     * 4、(rand5-1)*5+(rand5-1)：随机产生0,1,2,3,4,5,6...23,24。类似插空儿
     * 5、上述步骤4产生的结果大于20，则重复进行步骤4，直到产生的结果在0~20之间，然后在进行%7操作，
     * 可以随机产生0~6之间的数，这就是“筛”的过程
     *
     * 二、进阶问题
     * 给定某个区间上的等概率随机函数，实现任意区间上的随机函数
     * 给定1~M的随机函数生成，实现1~N的随机函数生成
     * 1、M>N,直接进入筛选过程，也就是重复进行随机数生成，直到随机数范围满足要求
     * 2、M<N，先进行插空，使得产生的随机数范围大于N，然后进行筛选
     */
    // 等概率随机生成1-5之间的数
    public static int rand1To5(){
        return (int)(Math.random()*5)+1;
    }

    //使用rand5 ,等概率的生成1-7之间的数
    public static int rand1To7(){
        int num = 0;
        do{
            num = (rand1To5()-1)*5+rand1To5()-1;
        }while (num>20);
        return num&7+1;
    }


    public static int rand1ToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    public static int rand1ToN(int n, int m) {
        int[] nMSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    // 把value转成m进制的数
    public static int[] getMSysNum(int value, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (value != 0) {
            res[index--] = value % m;
            value = value / m;
        }
        return res;
    }

    // 等概率随机产生一个0~nMsys范围上的数，只不过是m进制表达的。
    public static int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0) {
            start++;
        }
        int index = start;
        boolean lastEqual = true;
        while (index != nMSys.length) {
            res[index] = rand1ToM(m) - 1;
            if (lastEqual) {
                if (res[index] > nMSys[index]) {
                    index = start;
                    lastEqual = true;
                    continue;
                } else {
                    lastEqual = res[index] == nMSys[index];
                }
            }
            index++;
        }
        return res;
    }

    // 把m进制的数转成10进制
    public static int getNumFromMSysNum(int[] mSysNum, int m) {
        int res = 0;
        for (int i = 0; i != mSysNum.length; i++) {
            res = res * m + mSysNum[i];
        }
        return res;
    }

    public static void printCountArray(int[] countArr) {
        for (int i = 0; i != countArr.length; i++) {
            System.out.println(i + " appears " + countArr[i] + " times");
        }
    }

    public static void main(String[] args) {

        int n = 17;
        int m = 3;
        int[] countArr3 = new int[n + 1];
        for (int i = 0; i != 20000000; i++) {
            countArr3[rand1ToN(n, m)]++;
        }
        printCountArray(countArr3);

        System.out.println("=====================");

    }
}
