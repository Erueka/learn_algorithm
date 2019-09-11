package InnerClass;

/**
 * @author Ling
 * Created on 2019/9/11
 *
 * 内部类定义在外部类里
 * 内部类可以访问外部类的成员，包括私有
 * 外部类想要访问内部类，必须要创建对象
 *
 *
 * 在类的成员位置  成员内部类
 * 在类的局部位置  局部内部类
 */
public class Demo1 {
    public static void main(String[] args) {
        // 方法一
        // 创建成员内部类的对象，并调用其方法；
        // 前提内部内用public修饰符，这种方法不常用；
        //Outter.Inner oi = new Outter().new Inner();
        //oi.show();

        // 方法二
        Outter o = new Outter();
        o.showMethod();

    }
}
