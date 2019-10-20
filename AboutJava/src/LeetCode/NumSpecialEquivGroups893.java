package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ling
 * Created on 2019/10/20
 */
public class NumSpecialEquivGroups893 {
    public static int numSpecialEquivGroups(String[] A) {
        // 奇数位和偶数位上字符相同的为一组
        Set<String> groups = new HashSet<>();
        for (String s : A) {
            String odd = "", even = "";
            char[] char_arr = s.toCharArray();
            for (int i = 0; i < char_arr.length; i++) {
                if (i % 2 == 0)
                    even += char_arr[i];
                else
                    odd += char_arr[i];
            }
            char[] odd_arr = odd.toCharArray();
            Arrays.sort(odd_arr);
            char[] even_arr = even.toCharArray();
            Arrays.sort(even_arr);
            String together = new String(odd_arr) + new String(even_arr);
            groups.add(together);
        }
        return groups.size();
    }

    public static void main(String[] args) {
        String[] s = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        System.out.println(numSpecialEquivGroups(s));
    }
}
