package LeetCode.CSUOJ.PIPIdaguai.纸币;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int round = scan.nextInt(); //轮数
        for (int r = 0; r < round; r++) {
            int n = scan.nextInt();
            int S = scan.nextInt();
            int[] coin = new int[n];
            for (int i = 0; i < n; i++)
                coin[i] = scan.nextInt();
            int max = S + 1;
            int[] dp = new int[S+1];
            Arrays.fill(dp,max);
            dp[0] = 0;
            for (int i=0;i<=S;i++) {
                for (int j=0;j<coin.length;j++) {
                    if (coin[j] <= i) {
                        dp[i] = Math.min(dp[i],dp[i-coin[j]]+1);
                    }
                }
            }
            System.out.println(dp[S]+" "+S);
        }
    }
}
