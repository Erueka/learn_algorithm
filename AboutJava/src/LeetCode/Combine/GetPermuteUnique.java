package LeetCode.Combine;

import LeetCode.MergeKLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GetPermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        int[] used = new int[len];
        Arrays.sort(nums);
        helper(nums, used, new Stack<>());
        return res;
    }

    private void helper(int[] nums, int[] used, Stack<Integer> s) {
        if (s.size() == len) {
            res.add(new ArrayList<>(s));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 被使用过，或者与自己左边那棵树相同
            if (used[i] == 1 || i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)
                continue;
            s.push(nums[i]);
            used[i] = 1;
            helper(nums, used, s);
            s.pop();
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        GetPermuteUnique g = new GetPermuteUnique();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = g.permuteUnique(nums);
        System.out.println(res);
    }
}
