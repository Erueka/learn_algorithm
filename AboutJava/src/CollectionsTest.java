import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ling
 * Created on 2019/9/8
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(2);
        a.add(23);
        a.add(-12);
        a.add(0);
        a.add(-99);

        System.out.println(a);
        Collections.reverse(a);
        System.out.println(a);

        Collections.sort(a, new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return -Integer.compare((int)o1, (int)o2);
            }
        });
        System.out.println(a);

        Collections.shuffle(a);
        System.out.println(a);
    }
}
