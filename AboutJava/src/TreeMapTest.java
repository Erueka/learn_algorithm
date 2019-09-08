import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Ling
 * Created on 2019/9/8
 */
class R implements Comparable{
    int count;

    public R(int count){
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {
        R r2 = (R)o;
        return this.count-r2.count;
    }

    @Override
    public String toString() {
        return "class:R count:"+count;
    }
}

class D{
    int count;

    public D(int count){
        this.count = count;
    }

    @Override
    public String toString() {
        return "class:D count:"+count;
    }
}
public class TreeMapTest {
    public static void main(String[] args) {
        //自然排序，key类为自定类需要实现Comparable接口，
        //大多数类已经实现了此接口，为升序排序。
        TreeMap tm = new TreeMap();
        tm.put(new R(1), "1");
        tm.put(new R(-2), "2");
        tm.put(new R(3), "3");
        tm.put(new R(-4), "4");
        System.out.println("第一个key："+tm.firstKey());
        System.out.println("删除第一个元素，其value："+tm.remove(tm.firstKey()));
        System.out.println("第一个key:"+tm.firstKey()+"\n\n");


        //自定排序，不需要改编自定类，传入了一个Copmarator对象（匿名内部类）用来构造TreeMap,
        //可按照自己意愿排序，这里为降序排序。
        TreeMap tm2 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                D d1 = (D)o1;
                D d2 = (D)o2;
                return d1.count > d2.count ? -1
                        : d1.count < d2.count ? 1 : 0;
            }
        });
        tm2.put(new D(1), "1");
        tm2.put(new D(-2), "-2");
        tm2.put(new D(3), "3");
        tm2.put(new D(-4), "-4");
        System.out.println("第一个key："+tm2.firstKey());
        System.out.println("删除第一个元素，其value："+tm2.remove(tm2.firstKey()));
        System.out.println("第一个key:"+tm2.firstKey());
    }
}
