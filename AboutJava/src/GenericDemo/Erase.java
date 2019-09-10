package GenericDemo;

/**
 * @author Ling
 * Created on 2019/9/10
 */
class Apple<T extends Number>{
    T info;
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
public class Erase {
    public static void main(String[] args) {
        Apple<Integer> a = new Apple<>(123);
        System.out.println(a.getInfo());

        Apple b = a;
        // 具有泛型信息的对象赋给没有泛型信息的变量时，发生了擦除
        // 类型检查变成了类型变量的上线，即Number
        // Integer info = b.getInfo();

        // 编译器认为info是Number类，而instanceOf判断为Integer
        // 可见，instanceOf检验的是运行时类型。
        System.out.println(b.info instanceof Integer);
    }
}
