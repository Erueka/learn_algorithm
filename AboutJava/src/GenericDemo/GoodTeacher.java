package GenericDemo;

/**
 * @author Ling
 * Created on 2019/9/10
 */
/*
当创建了带泛型生命的接口、父类后，可以为该接口创建实现类，或者从该父类派生子类，
但需要指出的是，当使用这些接口、弗雷什不能在包含类型形参。例如下面语句是错误的
    public class A extends Apple<T>{}
可改写成如下代码：
    public class A extends Apple<String>{}
下面代码也是正确的，接下来会介绍到
    public class A extends Apple{}

 */

/*直接继承Teacher，会把Teacher<T>类里的T形参当作Object类型处理。
public class GoodTeacher extends Teacher{
    @Override
    public Object getAge() {
        return super.getAge();
    }
}
*/

/*  Teacher类中，所有使用T参数的地方都被换成了String
public class GoodTeacher extends Teacher<String>{
    @Override
    public String getAge() {
        return super.getAge();
    }
}
*/

/*这样会报错，找不带类型T，父类保留类型形参，子类也必须保留。
public class GoodTeacher extends Teacher<T>{
    @Override
    public void setAge(T age) {
        super.setAge(age);
    }

    public static void main(String[] args) {

    }
}
*/

public class GoodTeacher<T,V> extends Teacher<T>{
    V level;

    public V getLevel() {
        return level;
    }

    public void setLevel(V level) {
        this.level = level;
    }

    @Override
    public T getAge() {
        System.out.println("这是GoodTeacher类重写的setter方法。");
        return super.getAge();
    }

    @Override
    public void info() {
        System.out.println("age:"+getAge()+"\tlevel:"+level);
    }
}