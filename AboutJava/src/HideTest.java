/**
 * @author Ling
 * Created on 2019/9/3
 */
class Parent{
    public String tag = "这是Parent的一条tag。";
    public Parent getThis(){
        return this;
    }
}

class Child extends Parent{
    private String tag = "这是Child的一条tag。";
    public Parent getSuper(){
        return super.getThis();
    }
}
public class HideTest {
    public static void main(String[] args) {
        Child c = new Child();
        // 程序不能访问Child的私有变量，下面语句会产生编译错误。
        // System.out.println(c.tag);
        // 将c变量向上住转型后，即可访问tag变量。
        System.out.println(((Parent)c).tag);

        Parent p = c.getSuper();
        // c的super对象和c仍是c对象本身。
        //只是他的编译时类型是Parenr，所以访问实例变量时会有所不同。
        System.out.println(p == c);
        System.out.println(p.tag);

    }
}
/*
当程序创建一个子类变量对象时，系统不仅会为该类中定义的实例变量分配内存，
也会为其父类中定义的所有实例变量分配内存，即使子类定义了与父类同名的实例变量，
也不会是简单的完全覆盖。
 */