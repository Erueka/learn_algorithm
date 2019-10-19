package LeetCode;

import java.util.*;

/**
 * @author Ling
 * Created on 2019/10/17
 */
public class SlideWindow {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;      // 滑动窗口为nums[left...right]
        int sum = 0;         // 窗口内数值和
        int ans = nums.length + 1;
        while (left < nums.length) {
            if (sum < s && right < nums.length - 1)
                sum += nums[++right];   // 先自增，时刻保持不变量，即每个变量对性的含义不变
            else
                sum -= nums[left++];

            if (sum >= s)
                ans = Math.min(ans, right - left + 1);
        }

        if (ans > nums.length)
            return 0;
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] dir = new int[256];
        Arrays.fill(dir, 0);
        int left = 0;
        int right = -1;     // [left...right]
        int ans = 0;
        char[] c = s.toCharArray();
        // 看下一个，如果没有有边界加一，如果已有左边界加一
        while (left < s.length() && right + 1 < s.length()) {
            if (dir[c[right + 1]] == 0)
                dir[c[++right]]++;
            else
                dir[c[left++]]--;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /*

    LeetCoed438 找到字符串中所有字母异位词
    给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
    输入:
    s: "cbaebabacd" p: "abc"

    输出:
    [0, 6]

     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // 如何确定窗口内的字符满足要求
        Map<Character, Integer> needs = new HashMap<>();     // 记录p中包含的字符及出现次数
        Map<Character, Integer> window = new HashMap<>();    // 记录窗口中包含的字符及出现次数
        for (char key : p.toCharArray())
            needs.put(key, needs.getOrDefault(key, 0) + 1); //初始化needs

        // 当window[i] >= needs[i]时该字符就满足条件
        // 当满足条件的字符数count==p.length时就时=是符合要求的window了
        int count = 0;

        int left = 0;
        int right = -1;
        while (left < s.length() && right + 1 < s.length()) {
            // 不断扩张right，知道满足条件，再缩小left
            char next_right = s.charAt(right + 1);
            if (needs.containsKey(next_right)) {    // 如果是需要的做记录，否则继续看下一个
                window.put(next_right, window.getOrDefault(next_right, 0) + 1); // windows[next_right]++
                count += window.get(next_right).equals(needs.get(next_right)) ? 1 : 0;
            }
            right++;

            // 注意这里是needs的size而不是p的len，因为p中可能包含重复字符，而count不区分重复字符
            while (count == needs.size()) {  // 已经找到满足条件的窗口，需要优化窗口
                if (right - left + 1 == p.length())    // 满足返回要求则记录
                    res.add(left);
                char now_left = s.charAt(left);         // left向右缩小
                if (needs.containsKey(now_left)) {      // 如果当前left是需要的，则需处理一下windows和count
                    window.put(now_left,window.get(now_left)-1);
                    count += window.get(now_left) < needs.get(now_left) ? -1 : 0;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> ans = findAnagrams("leetcode", "ee");
        System.out.println(ans);
    }
}
