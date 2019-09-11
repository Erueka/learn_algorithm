package InnerClass;

/**
 * @author Ling
 * Created on 2019/9/11
 */
public class StaticInnerClass {
    private int prop1 = 1;
    private static int prop2 = 2;

    static class InnerClass{
        private int prop3 = 3;
        private static int prop4 = 4;

        public void accessOuterClass(){
            //静态成员无法访问非静态成员
            //System.out.println(prop1);

            //下面输出正常
            System.out.println(prop2);
        }
    }

    public void accessInnerClass(){
        //通过类名.的方式访问内部类的静态成员。
        System.out.println(InnerClass.prop4);

        //通过实例访问静态内部类的实例成员
        System.out.println(new InnerClass().prop3);
    }

    public static void main(String[] args) {
        StaticInnerClass.InnerClass si = new StaticInnerClass.InnerClass();
        si.accessOuterClass();

        StaticInnerClass s = new StaticInnerClass();
        s.accessInnerClass();

    }
}
