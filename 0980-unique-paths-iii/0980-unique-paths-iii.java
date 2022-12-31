class Solution {
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0, sx, sy;
        int empty = 1;
        sx=sy=0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, empty);
    }

    public int dfs(int[][] grid, int x, int y, int empty) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)
            return 0;
        if (grid[x][y] == 2) {
            if (empty == 0) return 1;
            return 0;
        }
        grid[x][y] = -2;
        empty--;
        int ways = 0;
        ways+= dfs(grid, x + 1, y, empty);
        ways += dfs(grid, x - 1, y, empty);
        ways += dfs(grid, x, y + 1, empty);
        ways += dfs(grid, x, y - 1, empty);
        grid[x][y] = 0;
        empty++;
        return ways;
    }
}