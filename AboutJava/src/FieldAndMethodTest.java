/**
 * @author Ling
 * Created on 2019/9/3
 */
class Base{
    int count = 2;
    public void display(){
        System.out.println(this.count);
    }
}

class Derived extends Base{
    int count = 20;
    @Override
    public void display(){
        System.out.println(this.count);
    }
}

public class FieldAndMethodTest {
    public static void main(String[] args) {
        Base b = new Base();
        System.out.println(b.count);
        b.display();

        Derived d = new Derived();
        System.out.println(d.count);
        d.display();

        Base bd = new Derived();
        System.out.println(bd.count);
        bd.display();

        Base d2 = d;
        System.out.println(d2.count);
        d2.display();
    }
}

/*
通过变量调用方法时，方法总是表现出他们实际类型的行为。
通过变量来访问他们所指对象的实例变量，实例变量的值总是表现出声明这些变量所用的类型的行为。
 */