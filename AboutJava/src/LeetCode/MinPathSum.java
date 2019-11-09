package LeetCode;

import java.util.Arrays;

public class MinPathSum {
    // 自底向上
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        for (int i = grid.length - 1; i >= 0; i--) {    // 行遍历
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (i != grid.length - 1 && j != grid[i].length - 1)
                    grid[i][j] = Math.min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j];
                else if (i != grid.length - 1)
                    grid[i][j] = grid[i + 1][j] + grid[i][j];
                else if (j != grid[i].length - 1)
                    grid[i][j] = grid[i][j + 1] + grid[i][j];
                else
                    grid[i][j] = grid[i][j];
            }
        }
        return grid[0][0];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];     // 从[m][n]到右下角的全部路径
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    dp[i][j] = 1;
                else if (i == m - 1)
                    dp[i][j] = dp[i][j + 1];
                else if (j == n - 1)
                    dp[i][j] = dp[i + 1][j];
                else
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];     // 从左上角到[m][n]的路径数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[0][0];
    }

    public int uniquePaths3(int m, int n) {
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public int uniquePaths4(int m, int n) {
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int[][] dp = new int[2][2];
        Arrays.fill(dp, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else {
                    dp[i % 2][j % 2] = dp[(i-1)%2][j%2] + dp[i%2][(j-1)%2];
                }
            }
        }
        return dp[1][1];
    }



    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSums4(grid));
    }
}
