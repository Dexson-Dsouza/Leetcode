class Solution {
    public int closedIsland(int[][] grid) {
        int closedIsland=0;
        for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if((i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1) && grid[i][j]==0){
                  dfs(grid,i,j);
              }
          }   
        }
        
        for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]==0){
                  dfs(grid,i,j);
                  closedIsland++;
              }
          }   
        }
        return closedIsland;
    }
    public void dfs(int[][] grid,int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length ||grid[row][col]==1) return;
        
        grid[row][col]=1;
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
        
    }
}