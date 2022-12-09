class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands=0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==1){
                    if(dfs(grid1,grid2,i,j)){
                        subIslands++;
                    }
                }
            }
        }
        return subIslands;
    }
    public boolean dfs(int[][] grid1,int[][] grid2,int row,int col){
        if(row<0 || row>=grid2.length || col<0 || col>=grid2[0].length || grid2[row][col]==0) return true;
        boolean isSubIsland = false;
        if(grid1[row][col]==1){
            isSubIsland = true;
        }
        grid2[row][col]=0;
        isSubIsland&=dfs(grid1,grid2,row+1,col);
        isSubIsland&=dfs(grid1,grid2,row-1,col);
        isSubIsland&=dfs(grid1,grid2,row,col+1); 
        isSubIsland&=dfs(grid1,grid2,row,col-1);
        return isSubIsland;
    }
}