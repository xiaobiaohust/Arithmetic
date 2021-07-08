package ThinkInJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * 数组
 */
public class arrays {
    /**
     * 一：数组特点
     * 1：数组是一种效率最高的存储和随机访问对象引用序列的方式
     * 2：数组长度无法改变
     * 3：数组标识符指向堆中创建的一个对象，这个对象又指向其他的引用
     * 4：数组可以通过new显式创建
     * 5：数组有唯一一个length方法或者属性
     * 6：数组与泛型不能很好地结合，不能实例化具有参数化类型的数组
     * 7：Arrays。fill用某个值将数组填充
     */
    public static void f1() {
        int[] a = new int[8];
        int[] b = {12, 23, 213};
        System.out.println(Arrays.toString(a));
        Arrays.fill(a, 100);
        System.out.println(Arrays.toString(a));

        int[][] c = new int[2][3];
        int[][] d = {{1, 2}, {3, 23}};
        System.out.println(Arrays.deepToString(d));
    }

    /**
     * 二：Arrays实用功能
     * 1：equals、fill、sort、toString、hashCode
     */
    public static void f2() {
        int[] a = new int[8];
        int[] b = new int[10];
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        Arrays.fill(a, 6666);
        System.arraycopy(a, 0, b, 0, a.length);//赋值数组，比起for循环好
        System.out.println(Arrays.toString(b));

    }

    /**
     * 三：数组比较排序
     * 1：Comparable自然排序，
     * 继承Comparable,实现compareTo方法，接受一个对象参数；
     *
     * 可通过Collections.sort()、Arrays.sort()排序
     * 实现了Comparable接口可用于TreeMap、TreeSet
     *     compareTo:
     *
     *      当前对象大于参数对象，返回正值
     *      当前对象等于参数对象，返回0
     *      当前对象大于参数对象，返回负值
     * 2：Comparator定制排序
     */
    public static class sortTest implements Comparable<sortTest> {
        int value1;
        int value2;

        public sortTest() {
            value1 = (int) (Math.random() * 100);
            value2 = (int) (Math.random() * 100);
        }

        public String toString() {
            return String.valueOf(value1);
        }

        public int compareTo(sortTest obj) {
            return (value1 < obj.value1 ? -1 : (value1 == obj.value1 ? 0 : 1));
        }
    }

    public static class AscSort implements Comparator<sortTest>{
        @Override
        public int compare(sortTest obj1,sortTest obj2){
            return obj1.value1-obj2.value1;
        }
    }
    public static class DescSort implements Comparator<sortTest>{
        @Override
        public int compare(sortTest obj1,sortTest obj2){
            return obj2.value1-obj1.value1;
        }
    }

    public static void f3() {
        sortTest[] a = new sortTest[8];
        for (int i = 0; i < a.length; ++i) {
            a[i] = new sortTest();
        }
        Arrays.sort(a,new AscSort());
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; ++i) {
            a[i] = new sortTest();
        }
        Arrays.sort(a,new DescSort());
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; ++i) {
            a[i] = new sortTest();
        }
        Arrays.sort(a, Collections.reverseOrder());//reverseOrder用来反转
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
//        f1();
//        f2();
        f3();
    }
}
