package LeetCode;

/**
 * @author Ling
 * Created on 2019/9/18
 */
public class ReverseInt {
    public int reverse(int x) {
        int pop = 0;
        int rev = 0;
        int temp = 0;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop == 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop == 8) return 0;
            temp = rev * 10;
            rev = temp + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInt r = new ReverseInt();
        System.out.println(r.reverse(-12344));
        System.out.println(2%-5);
        System.out.println(5%2);
        System.out.println(-2%5);
        System.out.println(-5%2);
        System.out.println(-2%-5);
        System.out.println(-5%-2);
        // 结论1：一个负数参与取模，当作正数运算，余数与被取模数相同。
        // 结论2：两个负数取模，余数总为负数。

    }
}
