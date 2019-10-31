package LeetCode.QuickPower;

/**
 * @author Ling
 * Created on 2019/10/31
 */
public class QuickPower {
    public static long quikcPower(int a, int b) {
        long ans = 1, base = a;
        while (b > 0) {
            if ((b&1)==1)
                ans *= base;
            base *= base;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(quikcPower(2,50));
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0);
    }
}
