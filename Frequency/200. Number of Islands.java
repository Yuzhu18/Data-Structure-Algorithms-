class Solution {
    // recursion tree:
    // each level represents one spot which is "1"
    // each level has four branches, which is left, right, up, down
    // 要用array 来记录已经被遍历的格子
    // Time: O(n^2)  -- 遍历了grid每个格子，每次check O(1)
    // Spcae: O(n ^ 2) -- recursion 最差情况是全是1

    public int numIslands(char[][] grid) {
        int rst = 0;
        // corner case:
        if (grid == null || grid.length == 0) {
            return rst;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    rst++;
                    dfs(grid, i, j);
                }
            }
        }
        return rst;
    }
    
    private void dfs (char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' ) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
