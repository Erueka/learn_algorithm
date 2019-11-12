package LeetCode.N皇后;

import java.util.*;

public class Solution {
    private int n = 0;
    private List<List<String>> res = new ArrayList<>();
    private Set<Integer> col;   // 哈希表记录哪些列已有皇后
    private Set<Integer> master;// 记录哪些主对角线上有皇后，坐标之差
    private Set<Integer> slave; // 记录副对角线

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        if (n == 0)
            return res;
        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();
        helper(0, new Stack<>());
        return res;
    }

    private void helper(int curRow, Stack<Integer> s) {
        if (curRow == n) {
            List<String> list = convert2Board(s, n);
            res.add(list);
            return;
        }

        // 对当前行遍历
        for (int i = 0; i < n; i++) {
            // 列内不存在，主副对角线不存在皇后
            if (!col.contains(i) && !master.contains(i + curRow)
                    && !slave.contains(i - curRow)) {
                s.push(i);
                col.add(i);
                master.add(i + curRow);
                slave.add(i - curRow);
                helper(curRow + 1, s);
                col.remove(i);
                master.remove(i + curRow);
                slave.remove(i - curRow);
                s.pop();
            }
        }
    }

    private List<String> convert2Board(Stack<Integer> s, int n) {
        List<String> list = new ArrayList<>();
        for (int num : s) { // stack的foreach遍历是从栈底到栈顶
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++)
                sb.append('.');
            sb.replace(num, num + 1, "Q");
            list.add(new String(sb));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        List<List<String>> res = s.solveNQueens(4);
        System.out.println(res);
    }
}
