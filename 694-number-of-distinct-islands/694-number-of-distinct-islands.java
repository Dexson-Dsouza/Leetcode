class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> islandSet=new HashSet<>();
        
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    StringBuilder islandKey=new StringBuilder();
                    getIslandKey(grid,row,col,0,0,islandKey);
                    islandSet.add(islandKey.toString());
                }
            }
        }
        return islandSet.size();
    }
    
    void getIslandKey(int[][] grid, int row, int col, int x, int y, StringBuilder islandKey){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0){
            return;
        }
        islandKey.append(x+" "+y+"*");
        grid[row][col]=0;
        getIslandKey(grid,row+1,col,x+1,y,islandKey);
        getIslandKey(grid,row-1,col,x-1,y,islandKey);
        getIslandKey(grid,row,col+1,x,y+1,islandKey);
        getIslandKey(grid,row,col-1,x,y-1,islandKey);
    }
}