package LeetCode;

import java.util.LinkedList;

/**
 * @author Ling
 * Created on 2019/9/18
 */
public class IsIntPalindrome {

    public boolean isPalindrome(int x) {
        String s = x + "";
        char[] c1 = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        boolean result = false;
        for (int i = 0; i < c1.length; i++)
            stack.push(c1[i]);
        for (int i = 0; i < c1.length; i++) {
            char temp = stack.pop();
            if (temp == c1[i])
                result = true;
            else
                return false;
        }
        return result;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) // 以0结尾不可能为回文
            return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return x==reversed || x==reversed/10;
    }

    public static void main(String[] args) {
        IsIntPalindrome a = new IsIntPalindrome();
        System.out.println(a.isPalindrome2(1000021));
    }
}
