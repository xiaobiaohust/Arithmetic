package InterviewGuildCode.Others;

/**
 * 判断一个点是否在三角形内部
 * 在二维坐标中，所有值都是double，给定三个点的坐标，在给定一个点，判断改点
 * 是否在三角形中。
 * <p>
 * 思路：不知道具体的顶点，不好用直线直接判断
 * 方法一：从面积的角度来解决，给定点在三角形外面，分别和三条边组成
 * 三角形，求三个三角形的面积和，如果大于原始三角形，则在外面，否则在里面
 * 由于double类型数值有精度，很可能会出现一定程度的偏差，导致判断出错
 * <p>
 * 方法二：向量积（叉乘），绝对值表示两个向量围成的平行四边形，正负
 * 表示两个向量的相对夹角
 */
public class Problem_05_PointInTriangle {
    public static double crossProduct(double x1, double y1, double x2, double y2) {
        return x1 * y1 - x2 * y1;
    }

    public static boolean isInside(double x1, double y1, double x2, double y2, double x3, double y3, double x, double y) {
        // x1,x2,x3三个点不是顺时针，交换x2,x3
        if (crossProduct(x2 - x1, y2 - y1, x3 - x1, y3 - y1) < 0) {
            double tmpx = x2;
            double tmpy = y2;
            x2 = x3;
            y2 = y3;
            x3 = tmpx;
            y3 = tmpy;
        }

        if(crossProduct(x2-x1,y2-y1,x-x1,y-y1)<0){
            return false;
        }
        if(crossProduct(x3-x2,y3-y2,x-x2,y-y2)<0){
            return false;
        }
        if(crossProduct(x1-x3,y1-y3,x-x3,y-y3)<0){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        double x1 = -5;
        double y1 = 0;
        double x2 = 0;
        double y2 = 8;
        double x3 = 5;
        double y3 = 0;
        double x = 0;
        double y = 5;
        System.out.println(isInside(x1, y1, x2, y2, x3, y3, x, y));

    }
}
