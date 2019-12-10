package LeetCode.CSUOJ.PIPIdaguai.臭味相投;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] favo = new int[n + 1]; //每个人最喜欢的书
            int[] count = new int[m + 1];//每本书被喜欢的次数
            for (int i = 1; i <= n; i++) {
                favo[i] = scanner.nextInt();
                count[favo[i]]++;
            }
            for (int i = 1; i <= n; i++) {
                if (count[favo[i]]>1)
                    System.out.println(count[favo[i]]-1);
                else
                    System.out.println("BeiJu");
            }
        }
    }
}
