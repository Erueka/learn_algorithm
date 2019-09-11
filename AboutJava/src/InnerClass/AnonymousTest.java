package InnerClass;

/**
 * @author Ling
 * Created on 2019/9/11
 */
interface Product {
    double getPrice();

    String getName();
}


abstract class Product2 {
    public String name;

    public Product2(String name) {
        this.name = name;
    }

    abstract double getPrice();

    abstract String getName();
}


public class AnonymousTest {
    // 传入接口实例
    public static void test(Product p) {
        System.out.println("购买了" + p.getName() + "，花费了" + p.getPrice() + "元。");
    }

    // 重载的方法，传入的是一个抽象类实例
    public static void test(Product2 p) {
        System.out.println("购买了" + p.getName() + "，花费了" + p.getPrice() + "元。");
    }

    public static void main(String[] args) {
        // 如果某一接口的实现类只需使用一次，则应该用匿名内部类，
        // 否则应该定义单独的类。
        // 匿名内部类只有一个隐式无参数构造器，所以括号里不跟参数。
        test(new Product() {
            @Override
            public double getPrice() {
                return 49.9;
            }

            @Override
            public String getName() {
                return "毛衣";
            }
        });

        // 但如果通过继承父类使用匿名内部类，则可拥有父类的构造器，可传入参数。
        test(new Product2("洗衣机") {
            @Override
            double getPrice() {
                return 1234.99;
            }

            @Override
            String getName() {
                return this.name;
            }
        });
    }
}
// PS: 局部内部类访问外部类的局部变量，则必须使用final修饰符该局部变量（宏替换？？）