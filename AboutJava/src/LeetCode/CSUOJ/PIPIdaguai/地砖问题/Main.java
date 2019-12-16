package LeetCode.CSUOJ.PIPIdaguai.地砖问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int W = scanner.nextInt();  // 列数
            int H = scanner.nextInt();  // 行数
            if (W == 0 && H == 0)
                break;
            char[][] floor = new char[H][W];
            int startx, starty;
            for (int i = 0; i < H; i++) {
                String str = scanner.nextLine();
                for (int j = 0; j < W; j++) {
                    char c = str.charAt(j);
                    floor[i][j] = c;
                    if (c == '@') {
                        startx = i;
                        starty = j;
                    }
                }
            }

        }
    }
}
