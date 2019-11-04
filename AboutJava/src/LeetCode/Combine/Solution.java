package LeetCode.Combine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ling
 * Created on 2019/11/4
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k)
            return res;
        generateCombine(n, k, 1, new Stack<Integer>());
        return res;
    }

    // 从1到n的数字选k个，从start开始选，保存到c中
    private void generateCombine(int n, int k, int start, Stack<Integer> c) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }
        // 剪枝：[i...n]至少要有k-c.size()个数
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            generateCombine(n, k, i + 1, c);
            c.pop();
        }
        return;
    }
}
