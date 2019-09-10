package GenericDemo;

/**
 * @author Ling
 * Created on 2019/9/10
 * 泛型方法
 */

/*
第一种方式：方法重载
public class Method {
    public void show(int msg){
        System.out.println(msg);
    }

    public void show(String msg){
        System.out.println(msg);
    }

    public boolean show(boolean msg){
        System.out.println(msg);
    }
}
调用方式：
Method m = new Method();
m.show(123);
m.shou(true);
m.show("nihao");
*/
/*
方式二：使用泛型类，但是新建对象麻烦。
public class Method<T>{
    public void show(T msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Method<Integer> m1 = new Method<>();
        m1.show(123);

        Method<String> m2 = new Method<>();
        m2.show("你好");

        Method<Boolean> m3 = new Method<>();
        m3.show(true);

     }
}*/

/*
第三种，建对象时不明确类型，调方法时才明确类型
 */
public class Method{
    public <T> void show(T msg){
        System.out.println(msg);
    }
    public static void main(String[] args) {
        Method m = new Method();
        m.show("nihaoma");
        m.show(123);
        m.show(true);
        m.show(12.34);
    }
}
