package LeetCode.Combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        int[] used = new int[nums.length];
        getPermute(nums,used,new Stack<>());
        return res;
    }

    private void getPermute(int nums[], int[] used, Stack<Integer> s) {
        if (s.size() == nums.length) {
            res.add(new ArrayList<>(s));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]==1)
                continue;
            s.push(nums[i]);
            used[i] = 1;
            getPermute(nums,used,s);
            s.pop();
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = p.permute(nums);
        System.out.println(res);
    }
}
