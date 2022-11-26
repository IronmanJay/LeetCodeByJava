package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IronmanJay
 * @Description: 37.解数独
 * @CreateTime: 2022-11-26  09:36
 */
public class p37_SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
    }

    private static boolean[][] row = new boolean[9][9];
    private static boolean[][] col = new boolean[9][9];
    private static boolean[][][] block = new boolean[3][3][9];
    private static boolean valid = false;
    private static List<int[]> spaces = new ArrayList<int[]>();

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    row[i][digit] = true;
                    col[j][digit] = true;
                    block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs_back_p37_SudokuSolver(board, 0);
    }

    public static void dfs_back_p37_SudokuSolver(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!row[i][digit] && !col[j][digit] && !block[i / 3][j / 3][digit]) {
                row[i][digit] = true;
                col[j][digit] = true;
                block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs_back_p37_SudokuSolver(board, pos + 1);
                row[i][digit] = false;
                col[j][digit] = false;
                block[i / 3][j / 3][digit] = false;
            }
        }
    }

}
