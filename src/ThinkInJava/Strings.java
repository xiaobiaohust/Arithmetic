package ThinkInJava;

import java.util.Formatter;

/**
 * 字符串处理
 */
public class Strings {
    /**
     * 一：不可变String
     * 1：String对象是不可变的，很多看似可变的操作都是创建了一个全新的String对象
     */

    /**
     * 二：重载“+”与StringBuilder
     * 1：String中的+、+=是java中仅有的两个重载的操作符
     * 2：由于String的不可变性，在重载的时候会创建很多String，这时候编译器会优化调用StringBuilder
     */
    public static void f2() {
        StringBuilder result = new StringBuilder();
        result.append("123");
        result.append("2323");
        System.out.println(result.toString());

    }

    /**
     * 三：无意识的递归
     * 1：java中的类都继承object，都含有toString方法；每个容器类都覆写了toString方法
     * ，并且能够表达容器自身以及容器所包含的对象
     */

    /**
     * 四：String上的操作
     * length、charAt、toCharArray
     * equals、equalsIgnoreCase、compareTo、contains
     * startWith、endsWith、indexOf、lastIndexof、
     * subString、concat、replace、toLowerCase、toUpperCase
     * trim、valueof
     */
    public static void f4() {

        String str = "asdads";
        System.out.println(String.valueOf(true));
        System.out.println(str.toCharArray());
        char[] biao = new char[10];
        str.getChars(1, 3, biao, 0);
        System.out.println(biao);
    }

    /**
     * 五：格式化输出
     * 1：Formatter类
     * 2：String.format()
     */
    public static void f5() {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("%s sddf %s", "你好", "我说"));
        System.out.println(String.format("%s sddf %s", "你好", "我说"));

    }

    /**
     * 六：正则表达式
     * 1：字符串String类具有简单的正则匹配matches、split、replace、replaceAll
     * 2：正则表达式基本元素
     * （1）字符
     *      \t,\n,\r,\f,\e
     * （2）字符类
     *      .
     *      [abc]
     *      [^abc]
     *      [a-zA-Z]
     *      [abc[asd]]
     *      [a-z&&[hij]]
     *      \s,\S
     *      \d,\D
     *      \w,\W
     */
    public static void f6() {
        Formatter formatter = new Formatter();
        System.out.println("我324234我".matches("^我\\d+我$"));
        System.out.println(String.format("%s sddf %s", "你好", "我说"));

    }


    public static void main(String[] args) {
        f2();
        f4();
        f5();
        f6();
    }


}

