package BFS;

public class p130_SurroundedRegions {

    public static void main(String[] args) {

    }

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] queue = new int[m * n][2];
        int front = 0;
        int rear = 0;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                queue[rear][0] = 0;
                queue[rear++][1] = i;
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = 'A';
                queue[rear][0] = m - 1;
                queue[rear++][1] = i;
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                queue[rear][0] = i;
                queue[rear++][1] = 0;
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'A';
                queue[rear][0] = i;
                queue[rear++][1] = n - 1;
            }
        }
        while (front < rear) {
            int x = queue[front][0];
            int y = queue[front++][1];
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (cx < 0 || cx >= m || cy < 0 || cy >= n || board[cx][cy] != 'O') {
                    continue;
                }
                board[cx][cy] = 'A';
                queue[rear][0] = cx;
                queue[rear++][1] = cy;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
