package LeetCode.RecursionAndDp;

/**
 * 排成一条线的纸牌博弈问题
 * 给定一个整形数组，每次只能从最左或最右拿走一个，A先开始拿，A和B都是绝顶聪明
 * 的人，返回最后获胜者的分数
 */
public class Problem_14_CardsInLine {
    /**
     * 暴力递归
     * 1：定义递归函数f(i,j),表示arr[i~j]这个排列上的纸牌被聪明绝顶的人
     * 先拿，最终能获得什么分数
     * i=j，返回arr[i]
     * i!=j，返回max(arr[i]+s(i+1,j),arr[j]+s(i,j-1))
     * <p>
     * 2：定义递归函数s(i,j)，表示arr[i~j]这个排列上的纸牌被聪明绝顶的人
     * 后拿，最终能获得什么分数
     * i==j，返回0
     * i!=j，对手先拿，肯定会将最差的情况留给玩家，实际情况是，如果对手选择了
     * 的数，玩家剩下的选择只能是f(i+1,j),
     * 对手选择右边的数，玩家剩下的选择只能是f(i,j-1)
     * min(f(i+1,j),f(i,j-1))
     *
     *
     * 3：复杂度，递归有N层
     *     时间复杂度O(2^N)，空间复杂度O(N)
     */
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int i, int j) {
        if(i==j){
            return arr[i];
        }
        return Math.max(arr[i]+s(arr,i+1,j),arr[j]+s(arr,i,j-1));
    }
    public static int s(int[]arr,int i,int j){
        if(i==j){
            return 0;
        }
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }

    /**
     * 动态规划
     * 使用两个 NxN 矩阵表示f、s，计算两个矩阵的方向不一样，这个需要看
     * 依赖来决定
     * @param arr
     * @return
     */
    public static int win2(int[]arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        int[][]f =new int[arr.length][arr.length];
        int[][]s = new int[arr.length][arr.length];
        for(int j=0;j<arr.length;++j){
            f[j][j] =arr[j];
            for(int i = j-1;i>=0;--i){
                f[i][j] = Math.max(arr[i]+s[i+1][j],arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);


    }

    public static void main(String[] args) {
        int[] arr = { 2, 9, 10,1 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));

    }


}
