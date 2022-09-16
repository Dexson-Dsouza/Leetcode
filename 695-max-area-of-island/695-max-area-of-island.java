class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        
        int maxArea=0;
        
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    maxArea=Math.max(maxArea,findArea(grid,row,col,rows,cols));
                }
            }
        }
        return maxArea;
    }
    
    int[] dirs=new int[]{0,-1,0,1,0};
    
    public int findArea(int[][] grid, int r, int c, int rows, int cols){
        int count=1;
        grid[r][c]=0;
        for(int i=0;i<4;i++){
            int nr=r+dirs[i];
            int nc=c+dirs[i+1];
            
            if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                count += findArea(grid,nr,nc,rows,cols);
            }
        }    
        return count;
    }
}