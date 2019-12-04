package Knapsack;

import java.util.Arrays;

/**
 * @author Ling
 * Created on 2019/12/4
 */
public class Knapsack01 {
    // 递归的
    public int solution1(int[] w, int[] v, int c) {
        return helper(w, v, w.length - 1, c);
    }

    // 容量为c，从[0...index]的最大价值
    private int helper(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;

        int res = helper(w, v, index - 1, c);
        if (w[index] <= c)
            res = Math.max(res, v[index] + helper(w, v, index - 1, c - w[index])); // 不放容量不变，放了，容量变小
        return res;
    }


    // 记忆化搜索的
    int[][] memo;

    public int solution2(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[n][c + 1];
        return helper2(w, v, n - 1, c);
    }

    private int helper2(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;

        if (memo[index][c] != 0)
            return memo[index][c];
        int res = helper(w, v, index - 1, c);
        if (w[index] <= c)
            res = Math.max(res, v[index] + helper(w, v, index - 1, c - w[index])); // 不放容量不变，放了，容量变小
        memo[index][c] = res;
        return res;
    }


    // 动态规划
    public int solution3(int[] w, int[] v, int c) {
        int n = w.length;
        int[][] dp = new int[n][c + 1];
        for (int j = 0; j <= c; j++)
            dp[0][j] = w[0] <= j ? v[0] : 0;

        for (int i = 1; i < n; i++)
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j)
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
            }
        return dp[n - 1][c];
    }


    // 一维数组动态规划     最优解，时间空间都是最低
    public int solution4(int[] w, int[] v, int c) {
        int n = w.length;
        int[] memo = new int[c + 1];
        for (int j = 0; j <= c; j++)
            memo[j] = w[0] <= j ? v[0] : 0;

        for (int i = 1; i < n; i++)
            for (int j = c; j >= w[i]; j--)
                memo[j] = Math.max(memo[j], memo[j - w[i]] + v[i]);
        return memo[c];
    }


    public static void main(String[] args) {
        Knapsack01 k01 = new Knapsack01();
        int[] w = {1, 2, 3};
        int[] v = {6, 8, 10};
        System.out.println(k01.solution4(w, v, 5));
    }
}
