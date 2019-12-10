package LeetCode.CSUOJ.PIPIdaguai.旅行路线;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                int s = scanner.nextInt();
                for (int j = n - 1; j >= 0; j--) {
                    map[i][j] = s % 10;
                    s /= 10;
                }
            }
            int dp[][] = new int[n][n];
            dp[n - 1][n - 1] = 1;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int step = map[i][j];
                    if (i == n - 1 && j == n - 1)
                        continue;
                    if (j + step < n)
                        dp[i][j] += dp[i][j + step];
                    if (i + step < n)
                        dp[i][j] += dp[i + step][j];
                }
            }
            System.out.println(dp[0][0]);
        }
    }
}
