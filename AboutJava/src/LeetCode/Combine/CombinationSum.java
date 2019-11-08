package LeetCode.Combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Ling
 * Created on 2019/11/4
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        generateCombine(candidates, target, 0, new Stack<>());
        return res;
    }

    private void generateCombine(int[] candidates, int target, int start, Stack<Integer> s) {
        if (target == 0) {
            res.add(new ArrayList<>(s));
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i>0 && candidates[i]==candidates[i-1])
                continue;
            s.push(candidates[i]);
            generateCombine(candidates, target - candidates[i], i + 1, s);   // 元素可以重复，所以还是i
            s.pop();
        }
    }
}
