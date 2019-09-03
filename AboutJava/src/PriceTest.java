/**
 * @author Ling
 * Created on 2019/9/3
 */
class Price{
    final static Price INSTANCE = new Price(2.8);
    //这一句
    static double initPrice = 20;
    double currentPrice;
    public Price(double discount){
        currentPrice = initPrice - discount;
    }
}
public class PriceTest {
    public static void main(String[] args) {
        System.out.println(Price.INSTANCE.currentPrice);

        Price p = new Price(2.8);

        System.out.println(p.currentPrice);
    }
}
/*
对于注释标记处的那一句，加static与不加static结果截然不同，这是为什么呢？

JVM会对所有的变量先声明，在逐一赋值。
依据直接赋值==初始化块->构造器的顺序。

不加final，INSTANCE赋值时调用了构造函数，却还没对initPrice赋值，默认值为0，
所以输出就是-2.8。如果在调用构造函数前先对initPrice赋值，即将第一句第二句交换。
就能够正常输出17.2了。

加了final，则发生了宏替换。

对以一个final变量，不管它时类变量、实例变量、局部变量，只要它在定义该变量时
使用了final修饰符修饰，并且该变量的初始值可以在编译时就确定下来，那么这个
final变量的本质已经不再是一个变量，而是相当于了一个直接量。
除了赋值时直接赋直接量之外，如果被赋的是基本的算是表达式或者字符串连接运算，
没有访问普通变量，也会被宏替换。
注意：final变量只有在定义时指定初始值才会有宏替换的效果，在初始化块、构造器
中指定初始值不会有这种效果。
 */