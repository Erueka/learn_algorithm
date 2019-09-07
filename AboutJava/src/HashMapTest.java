import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Ling
 * Created on 2019/9/7
 */
class A{
    private int num;
    public A(int num){
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null &&
                obj.getClass() == A.class)
        {
            A a = (A)obj;
            return this.num == a.num;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.num;
    }

    @Override
    public String toString() {
        return "A: "+num;
    }
}

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<A, String> hm = new HashMap();
        hm.put(new A(1), "1");
        hm.put(new A(2), "2");
        hm.put(new A(3), "3");
        hm.put(new A(4), "4");
        hm.put(new A(5), "5");

        System.out.println("遍历：");
        for (Map.Entry<A,String> entry : hm.entrySet()){
            System.out.println("key="+entry.getKey()+"\tvalue="+entry.getValue());
        }
    }
}
