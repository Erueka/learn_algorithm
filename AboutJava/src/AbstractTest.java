/**
 * @author Ling
 * Created on 2019/9/4
 */
abstract class Shape{
    private String color;
    public Shape(String color){
        this.color = color;
    }
    public abstract double getPerimeter();
    public abstract String getTpye();
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }
}

class Triangle extends Shape{
    private double a;
    private double b;
    private double c;
    public Triangle(String color, double a, double b, double c){
        super(color);
        setSides(a, b, c);
    }
    private void setSides(double a, double b, double c){
        if (a>=b+c || b>=a+c || c>=a+b){
            System.out.println("三角形两边之和应大于第三边。");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getPerimeter(){
        return a+b+c;
    }
    public String getTpye(){
        return "三角形";
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        Shape s1 = new Triangle("红色", 3, 4, 5);
        System.out.println(s1.getColor());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getTpye());
        s1.setColor("蓝色");
        System.out.println(s1.getColor());
    }
}
/*
如果编写一个抽线父类，父类提供了多个子类通用的方法，并把一个或多个方法留给其
子类实现，这就是一种模板模式。模板模式的一些简单规则：

1、抽象父类之定义需要使用的某些方法，把不能实现的部分抽象成抽象方法，留给其子类去实现。
2、父类中可能包含需要调用其他方法的方法，这些被调用的方法可以由抽象父类实现，也可以由
其子类实现。父类李提供的方法只是定义了一个通用算法，其实先也许并不完全有自己实现，而必须
依赖于其子类的辅助。

一种更抽象的方式：接口
 */