package DFS;

/**
 * @Author: IronmanJay
 * @Description: 329.矩阵中的最长递增路径
 * @CreateTime: 2023-03-15  10:38
 */
public class p329_LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int res = longestIncreasingPath(matrix);
        System.out.println("res = " + res);
    }

    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 0) {
                    res = Math.max(res, dfs(matrix, i, j, temp));
                }
            }
        }
        return res;
    }

    public static int dfs(int[][] matrix, int i, int j, int[][] temp) {
        if (temp[i][j] != 0) {
            return temp[i][j];
        }
        int res = 1;
        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[i][j]) {
                res = Math.max(res, dfs(matrix, newRow, newCol, temp) + 1);
            }
        }
        temp[i][j] = res;
        return res;
    }

}
