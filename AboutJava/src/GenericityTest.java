import java.util.List;
import java.util.ListIterator;

/**
 * @author Ling
 * Created on 2019/9/8
 */
class Apple<T>{
    private T info;
    // 下面这句话会编译错误，静态方法、初始化块或者静态变量不允许使用类型形参
    // static int num;
    public Apple(T info){
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}

public class GenericityTest {
    public static void main(String[] args) {
        Apple<String> a1 = new Apple<>("this is a String.");
        Apple<Integer> a2 = new Apple<>(123);
        System.out.println(a1.getInfo()+"\n"+a2.getInfo());
    }

    public void test(List c){

    }
}
