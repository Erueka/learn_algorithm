package LeetCode;

import java.util.Arrays;

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
        while (left < s.length() && right+1<s.length()) {
            if (dir[c[right + 1]] == 0)
                dir[c[++right]]++;
            else
                dir[c[left++]]--;
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
