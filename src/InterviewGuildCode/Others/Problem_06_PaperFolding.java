package InterviewGuildCode.Others;

/**
 * 折纸问题
 * 思路：第一次对折产生的折痕数为1，第二次为2，第三次为4，第四次为8
 * 类似一棵二叉树，从上到下打印，就类似一棵二叉树的遍历，先右子树
 * 在跟节点，在左子树
 */
public class Problem_06_PaperFolding {
    public static void printAllFolds(int i,int N,boolean down){
        if(i>N){
            return;
        }
        printAllFolds(i+1,N,true);
        System.out.println(down?"down":"up");
        printAllFolds(i+1,N,false);
    }
    public static void main(String[] args) {
        int N = 4;
        printAllFolds(1,N,true);

    }
}
