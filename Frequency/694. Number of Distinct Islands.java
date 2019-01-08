
class Solution {
   
    // 同number of island I
    public int numDistinctIslands(int[][] grid) {
         Set<String> set= new HashSet<>();
        int res=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    StringBuilder sb= new StringBuilder();
                    helper(grid,i,j,0,0, sb);
                    String s=sb.toString();
                    if(!set.contains(s)){
                    res++;
                    set.add(s);
                    }
                }
            }
        }
            return res;
    }
    
    public  void helper(int[][] grid,int i,int j, int xpos, int ypos,StringBuilder sb){
        int[][] dirs= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        grid[i][j]=0;
        sb.append(xpos+""+ypos);
        for(int[] dir : dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0) continue;
            helper(grid,x,y,xpos+dir[0],ypos+dir[1],sb);
        }
    }
}
