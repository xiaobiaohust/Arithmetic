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
    public static boolean isInside1(double x1, double y1, double x2, double y2,
                                    double x3, double y3, double x, double y) {
        double area1 = getArea(x1, y1, x2, y2, x, y);
        double area2 = getArea(x1, y1, x3, y3, x, y);
        double area3 = getArea(x2, y2, x3, y3, x, y);
        double allArea = getArea(x1, y1, x2, y2, x3, y3);
        return area1 + area2 + area3 <= allArea;
    }

    public static double getArea(double x1, double y1, double x2, double y2,
                                 double x3, double y3) {
        double side1Len = getSideLength(x1, y1, x2, y2);
        double side2Len = getSideLength(x1, y1, x3, y3);
        double side3Len = getSideLength(x2, y2, x3, y3);
        double p = (side1Len + side2Len + side3Len) / 2;
        return Math.sqrt((p - side1Len) * (p - side2Len) * (p - side3Len) * p);
    }

    public static double getSideLength(double x1, double y1, double x2,
                                       double y2) {
        double a = Math.abs(x1 - x2);
        double b = Math.abs(y1 - y2);
        return Math.sqrt(a * a + b * b);
    }

    public static boolean isInside2(double x1, double y1, double x2, double y2,
                                    double x3, double y3, double x, double y) {
        // 如果三角形的点不是逆时针输入，改变一下顺序
        if (crossProduct(x3 - x1, y3 - y1, x2 - x1, y2 - y1) >= 0) {
            double tmpx = x2;
            double tmpy = y2;
            x2 = x3;
            y2 = y3;
            x3 = tmpx;
            y3 = tmpy;
        }
        if (crossProduct(x2 - x1, y2 - y1, x - x1, y - y1) < 0) {
            return false;
        }
        if (crossProduct(x3 - x2, y3 - y2, x - x2, y - y2) < 0) {
            return false;
        }
        if (crossProduct(x1 - x3, y1 - y3, x - x3, y - y3) < 0) {
            return false;
        }
        return true;
    }

    public static double crossProduct(double x1, double y1, double x2, double y2) {
        return x1 * y2 - x2 * y1;
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
        System.out.println(isInside1(x1, y1, x2, y2, x3, y3, x, y));
        System.out.println(isInside2(x1, y1, x2, y2, x3, y3, x, y));

    }
}
