package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ling
 * Created on 2019/9/21
 */
public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length-1; i++) {
            int per = roman.get(c[i]);
            int nex = roman.get(c[i+1]);
            if (per<nex)
                result -= per;
            else
                result += per;
        }
        result += roman.get(c[c.length-1]);
        return result;
    }
}
