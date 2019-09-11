package InnerClass;

/**
 * @author Ling
 * Created on 2019/9/11
 *
 *
 */
class OutClass{
    private String info = "外部类的成员。";

    class InClass{
        private String info = "内部类的成员。";

        public void test(){
            String info = "局部成员。";

            //外部类成员变量、内部类成员变量、内部类局部变量重名，按如下方式区分。
            System.out.println(OutClass.this.info);
            System.out.println(this.info);
            System.out.println(info);
        }
    }

    public void test(){
        InClass i = new InClass();
        i.test();
    }
}
public class Variable {
    public static void main(String[] args) {
        OutClass o = new OutClass();
        o.test();
    }
}
