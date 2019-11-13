class Solution {
    // 只有当岛屿是临界的时候，不符合条件，不是closed
    // 所以在判断的额时候出界的 return false
    // Time: O(n^2)
    // Space:O(n^2)
    
    public int closedIsland(int[][] grid) {
        int num = 0;
        if (grid == null || grid.length == 0) {
            return num;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if(dfs(grid, i, j)) {
                        num++;
                    } 
                }
            }
        }
        return num;
    }
    
    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        
        // !! 下面这个写法是错误❌的！！
        // 因为这道题在不断的改变grid, 如果直接用“&&” 遇到一个false，后面那就不会再执行了，导致其实没有完全check上下左右！！
        // return dfs(grid, i + 1, j) && dfs(grid, i - 1, j) && dfs(grid, i, j + 1) && dfs(grid, i, j - 1);
        
        boolean rst = true;
        rst &= dfs(grid, i + 1, j);
        rst &= dfs(grid, i - 1, j);
        rst &= dfs(grid, i, j + 1);
        rst &= dfs(grid, i, j - 1);
        return rst;
    }
}

