package LeetCode;

/**
 * @author Ling
 * Created on 2019/9/21
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int begin, int end) {
        if (begin == end) return strs[begin];
        else {
            int mid = (begin + end) / 2;
            String leftPerfix = longestCommonPrefix(strs, begin, mid);
            String rigthPerfix = longestCommonPrefix(strs, mid + 1, end);
            return compare(leftPerfix, rigthPerfix);
        }
    }

    private String compare(String left, String right) {
        int len = Math.min(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            while (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, len);
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] s = {"abcde", "abcd", "ab", "cc"};
        System.out.println(l.longestCommonPrefix(s));
    }
}
