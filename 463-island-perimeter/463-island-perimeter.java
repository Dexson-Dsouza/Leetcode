class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int perimeter=0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    perimeter+= findContribution(grid,row,col);
                }
            }
        }
        return perimeter;
    }
    
    public int findContribution(int[][] grid, int row, int col){
        int borderEgdeCount=0;
        int[] directions=new int[]{0,-1,0,1,0};
        
        for(int i=0;i<4;i++){
            int nr=row+directions[i];
            int nc=col+directions[i+1];
            if(isValid(grid,nr,nc)==false || grid[nr][nc]==0){
                borderEgdeCount++;
            }
        }
        return borderEgdeCount;
    }
    
    public boolean isValid(int[][] grid, int row, int col){
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length;
    }
}