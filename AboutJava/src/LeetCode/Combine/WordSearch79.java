package LeetCode.Combine;

/**
 * @author Ling
 * Created on 2019/11/9
 */
public class WordSearch79 {
    int m, n;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        assert m > 0;
        n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (search(board, word, 0, i, j))
                    return true;
        return false;
    }

    // 从board[x][y]开始查找word[index...len-1]
    private boolean search(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1)
            return board[x][y] == word.charAt(index);

        if (board[x][y] == word.charAt(index)) {
            used[x][y] = true;
            // 向四方寻找
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (inArea(newX, newY) && !used[newX][newY] &&
                        search(board, word, index + 1, newX, newY))
                    return true;
            }

            used[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}
