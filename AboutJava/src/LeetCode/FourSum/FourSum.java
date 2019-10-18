package LeetCode.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 先排序，用四个指针，固定前两个，包夹后两个。
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int a = 0; a + 3 < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;   // 对a去重
            for (int b = a + 1; b + 2 < nums.length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;//对b去重
                // 再利用对撞指针寻找target-nums[a]-nums[b]
                // 找不到则b++，再a++
                int find = target - nums[a] - nums[b];
                int c = b + 1;
                int d = nums.length - 1;

                while (c < d) {
                    if (nums[c] + nums[d] > find)
                        d--;
                    else if (nums[c] + nums[d] < find)
                        c++;
                    else {
                        List<Integer> ans = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        res.add(ans);
                        c++;
                        d--;
                    }
                }
            }
        }
        return res;
    }
}
