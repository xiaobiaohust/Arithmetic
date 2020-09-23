package InterviewGuildCode.RecursionAndDp;

/**
 *汉诺塔问题
 * 给定一个整数n,代表从小到大放置的n个圆盘，假设开始所有圆盘都放在左边柱子上，
 * ，按照要求，把所有的圆盘都移到右边的柱子上，实现函数打印最优移动轨迹
 *
 */
public class Problem_06_HanoiProblem {

    /**
     * 假设有from柱子、mid柱子、to柱子
     * 1：先将1~i-1从from移动到mid
     * 2：将i从from移动到to
     * 3：再将1~i-1从mid移动到to
     */

    public static void hanoi(int n){
        if(n>0){
            func(n,"left","mid","to");
        }
    }
    public static void func(int n,String from,String mid,String to){
        if(n==1){
            System.out.println("move from "+from+" to "+to);
        }else{
            func(n-1,from,to,mid);
            func(1,from,mid,to);
            func(n-1,mid,from,to);
        }
    }

    public static void main(String[] args) {
        int n = 20;
        hanoi(n);

    }
}
