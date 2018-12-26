class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        if(grid.length == 0){
            return num;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    num++;
                    helper(grid, i, j);
                }
            }
        }
        return num;
    }
    
    private void helper(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
    }
}
