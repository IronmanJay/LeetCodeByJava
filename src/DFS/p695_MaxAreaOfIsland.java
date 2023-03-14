package DFS;

/**
 * @Author: IronmanJay
 * @Description: 695.岛屿的最大面积
 * @CreateTime: 2023-03-14  10:07
 */
public class p695_MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0}};
        int res = maxAreaOfIsland(grid);
        System.out.println("res = " + res);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    public static int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(i + 1, j, grid);
        count += dfs(i, j + 1, grid);
        count += dfs(i - 1, j, grid);
        count += dfs(i, j - 1, grid);
        return count;
    }

}
