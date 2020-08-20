package ThinkInJava;

/**
 * 访问权限控制
 */
public class AccessAuthority {
    /**
     * 包
     * 1：java源代码文件称编译单元，必须以.java结尾，只能有一个public类，类名必须与文件名相同
     * 2：编译java源文件时，java文件中每个类都会生成一个class文件
     * 3：编译型语言通过编译链接生成可执行文件；java可运行程序是一组可以打包并压缩为一个java
     * 文档文件的class文件
     * 4：package语句申明源文件是类库或者包的一部分，想使用源文件，必须指定全名或者与包名结合使用关键字import
     * 5：用import改变行为
     *
     */

    /**
     * 访问修饰词
     * 1：public、protected、private、包访问权限（默认），是针对类的成员的
     * 2：包访问权限：包中的所有其他类对那个成员都有访问权限；对于包之外的类是private
     * 3：取得对某成员的访问权的唯一途径：
     *      * 使该成员成员public，无论是谁，无论在哪都可以访问
     *      * 不加访问修饰符，使得具有包访问权，包类成员可访问
     *      * 继承的protected成员也可以访问
     *      * 提供访问器和编译器方法，以读取和改变数值
     * 4：默认包，如果源文件没有指定包，将会存在该源文件目录下的默认包中
     * 5：public，接口访问权限
     * 6：private，除了包含该成员的类，任何其他类都无法访问。尽可能的将域和方法设为私有
     * 7：protected，继承访问权限，基类的创建者希望将某个特定成员的访问权限赋予派生类
     */

    /**
     * 接口和实现
     * 1：封装，将数据和方法包装进类中，以及具体实现的隐藏
     */


    /**
     * 类的访问权限
     * 1：类的访问权限只有public和包访问权限，没有private和protected
     */



    public static void main(String[]args){
        System.out.println("game start......");
    }
}
