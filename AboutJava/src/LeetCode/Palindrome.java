package LeetCode;

/**
 * @author Ling
 * Created on 2019/9/17
 */
public class Palindrome {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int length = s.length();
        if (length == 0)
            return "";
        for (int i = 0; i < length; i++) {
            int len1 = asCentre(s, i, i);         // 以某个单词为中心的回文
            int len2 = asCentre(s, i, i + 1);   // 以两个单词中间为中心的回文
            int len = len1 > len2 ? len1 : len2;
            if (len > end - start) {      // 有多个长度相同的回文，返回第一个，所以此用>而非>=
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 返回字符串某一位置为中心，构成回文的长度。
    public int asCentre(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        String s = "abcdcb";
        System.out.println(p.longestPalindrome(s));
    }
}
