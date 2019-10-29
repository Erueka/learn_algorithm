package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Ling
 * Created on 2019/10/21
 */
public class ClimbStairs {
    // 记忆化搜索--自顶向下

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];

        if (n == 0 || n == 1)
            return 1;

        if (dp[n] != 0)
            dp[n] = climbStairs1(n - 1) + climbStairs1(n - 2);

        return dp[n];
    }


    // 动态规划--自底向上
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }

}
