package UnionFind;


import java.util.Random;

/**
 * @author Ling
 * Created on 2019/10/28
 */
public class TestUnionFind {
    public static void testUF(int n) {
        UF3 uf = new UF3(n);
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);
            uf.unionElements(a, b);
        }
        for (int i = 0; i < n; i++) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);
            uf.isConnected(a, b);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        testUF(1000000);
        long end = System.currentTimeMillis();
        long time = (end - start);
        System.out.println(time/1000.0);
    }
}
