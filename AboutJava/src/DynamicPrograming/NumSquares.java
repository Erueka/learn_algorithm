package DynamicPrograming;

import java.util.Arrays;

/**
 * @author Ling
 * Created on 2019/10/23
 */
public class NumSquares {
    /*
    LeetCode 279
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     */

    // 方法一 ： 递归，减去所有可能的完全平方数，再对剩余部分递归求解   nanoTime 238000
//    public int numSquares(int n) {
//        return squaresNum(n);
//    }
//
//    private int squaresNum(int n) {
//        if (n == 0)
//            return 0;
//
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i * i <= n; i++) {
//            res = Math.min(1 + squaresNum(n - i * i), res);
//        }
//        return res;
//    }


    // 方法二：记忆化      // nanoTime 161000
//    int[] memo;
//    public int numSquares(int n) {
//        memo = new int[n+1];
//        Arrays.fill(memo, -1);
//        return squaresNum(n);
//    }
//
//    private int squaresNum(int n) {
//        if (n == 0)
//            return 0;
//
//        if (memo[n] != -1)
//            return memo[n];
//
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i * i <= n; i++) {
//            res = Math.min(1 + squaresNum(n - i * i), res);
//        }
//        memo[n] = res;
//        return res;
//    }

    // 自底向上，动态规划
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        long cur1 = System.nanoTime();
        System.out.println(n.numSquares(12));
        long nex1 = System.nanoTime();
        System.out.println((nex1 - cur1));
    }
}
