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


    // 二分法
    public String longestCommonPrefix(String[] strs, boolean binary) {
        if (strs.length == 0 || strs == null) return "";
        else {
            int minLen = Integer.MAX_VALUE;
            for (String s : strs)
                minLen = Math.min(minLen, s.length());  // 找到最短的字符串长度作为二分的上界

            int low = 1;
            int hight = minLen;

            while (low <= hight) {          // 二分查找最长前缀的长度
                int mid = (low + hight) / 2;
                if (isCommonPrefix(strs, mid)) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }

            return strs[0].substring(0, hight);
        }
    }

    public boolean isCommonPrefix(String[] strs, int pos) {
        String prefix = strs[0].substring(0, pos);
        for (String s : strs) {
            if (!s.startsWith(prefix)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] s = {"abcde", "abcd", "ab", "abcdef"};
        System.out.println(l.longestCommonPrefix(s, true));
    }
}
