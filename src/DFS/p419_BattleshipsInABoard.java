package DFS;

/**
 * @Author: IronmanJay
 * @Description: 419.甲板上的战舰
 * @CreateTime: 2023-03-13  08:48
 */
public class p419_BattleshipsInABoard {

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        int res = countBattleships(board);
        System.out.println("res = " + res);
    }

    public static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[i][j] == 'X') && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }

}
