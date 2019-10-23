package DynamicPrograming;

/**
 * @author Ling
 * Created on 2019/10/23
 */
public class NumDecoding {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];  // dp[i]表示到第i个（从1计）能组成的所有结果
        dp[0] = 1;
        if (s.charAt(0) != '0')
            dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            int one = Integer.parseInt(s.substring(i-1,i));
            int two = Integer.parseInt(s.substring(i-2,i));

            if (one != 0)
                dp[i] += dp[i-1];
            if (two>9 && two < 27)  // 0只能往前结合，不能往后结合， 如02不能当作2看作B处理。
                dp[i] += dp[i-2];   // 考虑到s=12类似这种情况，dp[0]必须为1
        }

        return dp[len];
    }

    public static void main(String[] args) {
        NumDecoding D = new NumDecoding();
        System.out.println(D.numDecodings("226"));
    }
}
