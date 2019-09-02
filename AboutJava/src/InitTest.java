/**
 * @author Ling
 * Created on 2019/9/2
 */
class Creature {
    static {
        System.out.println("Creature的静态初始化块。");
    }
    {
        System.out.println("Creature的非静态初始化块。");
    }
    public Creature(){
        System.out.println("Creature的无参构造器。");
    }
    public Creature(String name){
        this();
        System.out.println("Creature的带有参数name的构造器。");
    }
}
class Animal extends Creature{
    static {
        System.out.println("Animal的静态初始化块。");
    }
    {
        System.out.println("Animal的非静态初始化块。");
    }
    public Animal(String name){
        super(name);
        System.out.println("Animal的带有name的构造器。");
    }
    public Animal(String name, int age){
        this(name);
        System.out.println("Animal的带有name和age的构造器。");
    }
}
class Wolf extends Animal{
    {
        System.out.println("Wolf的非静态初始化块。");
    }
    public Wolf(){
        super("灰太狼", 3);
        System.out.println("Wolf的无参构造器。");
    }
    public Wolf(String weight){
        this();
        System.out.println("Wolf的带weight参数的构造器。");
    }
}
public class InitTest{
    public static void main(String[] args) {
        // 只要创建Java对象，系统总是先调用最顶层父类的初始化操作，
        // 初始化块和构造器，然后依次向下调用所有弗雷德初始化操作。
        // super用于显示调用父类的构造器，this用于显式调用本类重载
        // 的构造器。什么都不加，隐式调用父类的无参构造器。
        //
        // 非静态初始化块在创建实例时就会执行
        // 静态初始化块只有初始化类时才运行一次
        // JVM对类只初始化一次，即每次运行java程序时。
        Wolf w1 = new Wolf("4.9");
        System.out.println("\n");
        Wolf w2 = new Wolf("4.9");


    }
}