package InnerClass;

/**
 * @author Ling
 * Created on 2019/9/11
 * <p>
 * 对于非静态内部类而言，不但记录了外部类的详细信息，还保存了创建非静态内部类队形的引用，
 * 所以可以访问到外部类的成员，形成闭包。
 * <p>
 * 回调：表面上调用了一个Teachable对象的work方法，实际上回调了TeachableProgramer的teach方法
 */
interface Teachable {
    void work();
}


class Programer {
    private String name;

    public Programer() {
    }

    public Programer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(name + "正在灯下敲代码");
    }
}


// 即使teacher又是programer，接口和父类都有work方法，采用回调。
public class TeachableProgramer extends Programer {
    public TeachableProgramer() {
        super();
    }

    public TeachableProgramer(String name) {
        super(name);
    }

    public void teach() {
        System.out.println(getName() + "正在讲台上讲课。");
    }

    private class Closure implements Teachable {
        @Override
        public void work() {
            // 非静态成员内部类可以访问外部类的成员
            teach();
        }
    }

    // 返回一个非静态内部类对象的引用
    public Teachable getTeachable() {
        return new Closure();
    }

    public static void main(String[] args) {
        TeachableProgramer tp = new TeachableProgramer("铁憨憨");
        tp.work();
        // 表面上调用了一个Teachable对象的work方法，实际上回调了TeachableProgramer的teach方法
        tp.getTeachable().work();
    }
}

