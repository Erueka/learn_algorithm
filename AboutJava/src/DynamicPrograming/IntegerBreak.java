package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Ling
 * Created on 2019/10/21
 */
public class IntegerBreak {
    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }


    // 方法一：使用递归
    public int integerBreak1(int n) {
        return breakint(n);
    }

    private int breakint(int n) {
        // 递归终止条件
        if (n == 1)
            return 1;

        // 递归过程
        int res = -1;
        for (int i = 1; i < n; i++) {   // n = i + (n - i)
            res = max3(i * breakint(n - i), i * (n - i), res);
            // 因为n至少要分割为两个，而i * integerBreak1(n - i)至少会分割为3个
            // 所以还需要再加一个i * (n - i)
        }
        return res;
    }


    // 方法二：记忆化
    int[] memo;

    public int integerBreak2(int n) {
        memo = new int[n + 1];    // memo[i]表示i的最大分割结果
        Arrays.fill(memo, -1);  // 初值赋一个不可能的值
        return breakInt(n);
    }

    private int breakInt(int n) {
        if (n==1)
            return 1;

        if (memo[n] != -1)
            return memo[n];

        int res = -1;
        for (int i = 1; i < n; i++) {       // n=(n-i) + i
            res = max3(i * (n - i), i * breakInt(n - i), res);
        }
        memo[n] = res;
        return res;
    }


    // 动态规划
    public int integerBreak3(int n) {
        // 自底向上
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {      // 求dp[i]
            for (int j = 1; j < i; j++) {
                dp[i] = max3(j * (i - j), j * dp[i - j], dp[i]);
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        IntegerBreak i = new IntegerBreak();
        long cur = System.currentTimeMillis();
        System.out.println(i.integerBreak3(500));
        long nex = System.currentTimeMillis();
        System.out.println((double) (nex - cur) / 1000);
    }
}
