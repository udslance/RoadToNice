package cn.udslance.leetcode.mainofleetcode0;



/**
 * @author H
 * @create 2021-06-28 22:45
 */
public class Solution036 {

    
    public void test() {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));


        
    }

    public boolean isValidSudoku(char[][] board) {

        //存放行
        boolean[][] hang = new boolean[9][9];
        boolean[][] lie = new boolean[9][9];


        for (int i = 0; i < 9; i+=3) {

            for (int x = 0; x < 9; x+=3) {

                int[] ints = new int[10];

                for (int j = i; j < i + 3; j++) {

                    for (int k = x; k < x + 3; k++) {

                        if (board[j][k] == '.') {
                            continue;
                        } else {
                            int temp = board[j][k] - '1';

                            if (ints[temp] != 0) {
                                return false;
                            }

                            if (hang[j][temp] == true || lie[k][temp] == true) {
                                return false;
                            }

                            ints[temp] = temp;
                            hang[j][temp] = true;
                            lie[k][temp] = true;
                        }
                    }
                }
            }

        }


        return true;
    }
}
