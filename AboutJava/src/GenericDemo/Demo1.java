package GenericDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Ling
 * Created on 2019/9/10
 */
public class Demo1 {
    public static void main(String[] args) {
//        Collection<Integer> c = new ArrayList<>();
//        c.add(1);
//        c.add(2);
//        c.add(3);
//
//        //Ctrl+alt+v可自动生成左边类型。
//        Iterator<Integer> it = c.iterator();
//

        Teacher<Integer> t1 = new Teacher<>(30);
        Teacher<String> t2 = new Teacher<>("30");

        GoodTeacher<Integer, String> myTeacher = new GoodTeacher<>();
        myTeacher.setAge(30);
        myTeacher.setLevel("十佳教师");
        myTeacher.info();

    }
}
