package DynamicPrograming;

/**
 * @author Ling
 * Created on 2019/12/3
 */
public class Rob {
    public int rob(int[] nums) {
        // 动态规划
        int len = nums.length;
        if (len == 0)
            return 0;
        // dp[i]:偷取[i...len-1]的最大价值
        int[] dp = new int[len];
        dp[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--)
            for (int j = i; j < len; j++)
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < len ? dp[j + 2] : 0));
        return dp[0];
    }
}
