package JianZhiOffer.Chapter2;

/**
 * 机器人的运动范围
 * 使用回溯法
 */
public class P92_RobotMove {
    public static int movingCount(int threshold,int rowlen,int collen){

        boolean [][]visited = new boolean[rowlen][collen];
        int count = process(threshold,rowlen,collen,0,0,visited);
        return count;

    }
    public static int process(int threshold,int rowlen,int collen,int row,int len,boolean[][]visited){

    }

    public static void main(String[] args){
        System.out.println(movingCount(0,3,4)); //1
        System.out.println(movingCount(1,3,4)); //3
        System.out.println(movingCount(9,2,20)); //36
    }
}
