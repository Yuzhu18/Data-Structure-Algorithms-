// matrix 里面不一定只有0，1， 会存在其他数字，找出最大的数字岛
// 2 2 4 5 5 5
// 2 4 4 5 5 6
// 1 1 3 5 5 6
// rst - > 5的岛最大 -> return 7

public static int numIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int counter = DFS(grid, i, j, grid[i][j], visited);
                max = Math.max(max, counter);
            }
        }
        return max;
    }

   private static int DFS(int[][] grid, int x, int y, int curr, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] != curr) {
            return 0;
        }

        int res = 1;
        visited[x][y] = true;
        res += DFS(grid, x + 1, y, curr, visited);
        res += DFS(grid, x - 1, y, curr, visited);
        res += DFS(grid, x, y + 1, curr, visited);
        res += DFS(grid, x, y - 1, curr, visited);

        return res;
    }
