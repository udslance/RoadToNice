package cn.udslance.interview.mi;

/**
 * @author H
 * @create 2021-08-26 18:56
 */
public class Mi002 {

    public void test() {
        char[][] board = {{'x', 'y', 'z', 'e'}, {'s', 'f', 'z', 's'}, {'x', 'd', 'e', 'e'},};
        System.out.println(exist(board, "xyzy"));
    }

    public boolean exist(char[][] board, String word) {
        char[] wordC = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, wordC, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, char[] wordC, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != wordC[index]) {
            return false;
        }

        if (index == wordC.length - 1) {
            return true;
        }
        char rmb = board[i][j];
        board[i][j] = '!';

        boolean a = dfs(i - 1, j, board, wordC, index + 1) || dfs(i + 1, j, board, wordC, index + 1) || dfs(i, j - 1,
                board, wordC, index + 1) || dfs(i, j + 1, board, wordC, index + 1);



        board[i][j] = rmb;

        return a;
    }
}
