package DynamicPrograming;

/**
 * @author Ling
 * Created on 2019/10/23
 *
 * 直接动态规划的写法和使用滚动数组优化后的写法
 */
public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1)
            return 0;
        else
            dp[0][0] = 1;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (i == 0) {
                    if (j == 0)
                        continue;
                    dp[0][j] = dp[0][j - 1];
                } else if (j == 0)
                    dp[i][0] = dp[i - 1][0];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        return dp[m-1][n-1];
    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if (obstacleGrid[0][0] == 1)
            return 0;
        dp[0] = 1;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==1)  dp[j] = 0;
                else if (j>0)
                    dp[j] += dp[j-1];
                else    // 第一列
                    continue;// dp[j]=dp[j]; 即dp[i][j] = dp[i-1][j];
            }
        return dp[n-1];
    }
}
