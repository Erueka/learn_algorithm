package GenericDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ling
 * Created on 2019/9/10
 */
public class Copy {
    public static <T> T copy1(Collection<T> des, Collection<? extends T> src){
        T last = null;
        for (T elm : src){
            des.add(elm);
            last = elm;
        }
        return last;
    }

    public static <T> T copy2(Collection<? super T> des, Collection<T> src){
        T last = null;
        for (T elm : src){
            des.add(elm);
            last = elm;
        }
        return last;
    }

    public static void main(String[] args) {
        List<Number> des = new ArrayList<>();
        List<Integer> src = new ArrayList<>();

        src.add(1);
        src.add(2);
        src.add(3);
        src.add(4);

        // 方法一将引起编译错误，返回的类型时Number
        //Integer last = copy1(des, src);

        // 方法二
        Integer last = copy2(des, src);
        System.out.println(last);
    }
}
