package LeetCode;

/**
 * @author Ling
 * Created on 2019/9/23
 */
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < 13; i++) {
            while (num>=ints[i]){
                s.append(roman[i]);
                num -= ints[i];
            }
        }

        return s.toString();
    }
}
