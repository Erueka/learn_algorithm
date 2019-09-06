import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Ling
 * Created on 2019/9/6
 */
class Err{

}
class M{
    int age;
    public M(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "M[age:"+age+"]";
    }
}
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet nums = new TreeSet();
        nums.add(5);
        nums.add(-19);
        nums.add(2);
        nums.add(-4);
        nums.add(100);
        //添加一个Err对象没有问题，但是第二个会添加失败，
        //因为Err类没有实现Comarable接口，无法比较。
        //nums.add(new Err());
        //nums.add(new Err());
        System.out.println(nums);
        System.out.println(nums.first());
        System.out.println(nums.last());
        System.out.println(nums.headSet(10));
        System.out.println(nums.tailSet(0));

        TreeSet ts = new TreeSet(new Comparator() {
            public int compare(Object o1, Object o2) {
                M m1 = (M)o1;
                M m2 = (M)o2;
                return m1.age > m2.age ? -1 :
                        m1.age < m2.age ? 1 : 0;
            }
        });
        ts.add(new M(1));
        ts.add(new M(67));
        ts.add(new M(56));
        ts.add(new M(3));
        System.out.println(ts);
    }
}
/*
TreeSet并不是根据元素插入的顺序排序的，而是根据元素的实际值的大小进行排序的。
与HashSet使用hashCode决定元素位置不同，TreeSet使用红黑树的数据结构储存元素
TreeSet支持自然排序和定制排序。
1、自然排序
TreeSet调用集合元素的compareTo方法来比较元素之间的大小关系，然后将集合元素按升序排序，
java提供了一个Comparable接口，该接口定义了一个compareTo方法。java的一些常用类已经实现了这个接口

2、定制排序
如果要实现定制排序，如降序排序，可以通过Comarartor接口的帮助，该接口李包含一个compare（T O1, T O2）方法

 */