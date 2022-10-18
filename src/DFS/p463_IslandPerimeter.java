package DFS;

public class p463_IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int res = islandPerimeter(grid);
        System.out.println("res = " + res);
    }

    public static int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return dfs_p463_IslandPerimeter(grid, r, c);
                }
            }
        }
        return 0;
    }

    public static int dfs_p463_IslandPerimeter(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs_p463_IslandPerimeter(grid, r - 1, c) + dfs_p463_IslandPerimeter(grid, r + 1, c) + dfs_p463_IslandPerimeter(grid, r, c - 1) + dfs_p463_IslandPerimeter(grid, r, c + 1);
    }

}
