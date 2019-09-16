package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ling
 * Created on 2019/9/15
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        // start窗口起始，end窗口结束
        for (int end = 0, start = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar))
                // 包含下一字符，则把起始跳到子串中和下一字符相同的字符的后面一位
                // 再把下一字符加入map
                start = Math.max(start, map.get(endChar) + 1);
            // 时刻更新滑动窗口的最大数量
            result = Math.max(result, end - start + 1);
            map.put(endChar, end);
        }
        System.out.println(map);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("anviaj"));
    }
}
