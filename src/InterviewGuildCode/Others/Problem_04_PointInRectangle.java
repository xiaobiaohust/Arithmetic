package InterviewGuildCode.Others;

/**
 * 判断一个点是否在矩形内部
 * 在二维坐标系中，给定矩形的四个点的坐标，坐标为double类型，
 * 判断某个点是否在矩形中
 * 思路：
 * 1：先求矩阵的边平行于坐标轴的情况，分为上下左右
 * :2：不平行于坐标轴的情况，可以通过坐标变换，变成平行于
 * <p>
 * 思路2：直接求直线
 */
public class Problem_04_PointInRectangle {
    public static boolean isInside(double x1, double y1, double x4, double y4, double x, double y) {
        if (x <= x1 || x >= x4 || y >= y1 || y <= y4) {
            return false;
        }
        return true;
    }

    public static boolean isInside(double x1, double y1, double x2, double y2, double x3,
                                   double y3, double x4, double y4, double x, double y) {
        if (y1 == y2) {
            return isInside(x1, y1, x4, y4, x, y);
        }
        double l = Math.abs(y4 - y3);
        double k = Math.abs(x4 - x3);
        double s = Math.sqrt(k * k + l * l);
        double sin = l / s;
        double cos = k / s;
        double x1_ = x1 * cos + y1 * sin;
        double y1_ = y1 * cos - x1 * sin;
        double x4_ = x4 * cos + y4 * sin;
        double y4_ = y4 * cos - x4 * sin;
        double x_ = x * cos + y * sin;
        double y_ = y * cos - x * sin;
        return isInside(x1_, y1_, x4_, y4_, x_, y_);
    }

    //直接通过斜率来判断
    public static boolean isInside2(double x1, double y1, double x2, double y2, double x3,
                                    double y3, double x4, double y4, double x, double y) {
        double line1 = y - y1 - (y2 - y1) * (x - x1) / (x2 - x1);
        double line2 = y - y4 - (y2 - y4) * (x - x4) /(x2 - x4);
        double line3 = y - y4 - (y3 - y4) * (x - x4) / (x3 - x4);
        double line4 = y - y1 - (y3 - y1) * (x - x1) / (x3 - x1);

        if(line1>=0){
            return false;
        }
        if(line2>=0){
            return false;
        }
        if(line3<=0){
            return false;
        }
        if(line4<=0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // (x1,y1),(x2,y2),(x3,y3),(x4,y4) stand for a Rectangle.
        double x1 = 0;
        double y1 = 3;// (x1,y1) should be the most left
        double x2 = 3;
        double y2 = 7;// (x2,y2) should be the most top.
        double x3 = 4;
        double y3 = 0;// (x3,y3) should be the most below.
        double x4 = 7;
        double y4 = 4;// (x4,y4) should be the most right.

        double x = 4;
        double y = 3;
        System.out.println(isInside(x1, y1, x2, y2, x3, y3, x4, y4, x, y));
        System.out.println(isInside2(x1, y1, x2, y2, x3, y3, x4, y4, x, y));

    }


}
