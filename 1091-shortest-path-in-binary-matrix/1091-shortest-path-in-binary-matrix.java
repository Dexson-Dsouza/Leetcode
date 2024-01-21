class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> processing_coordinates = new LinkedList<>();
        
        // add start point for BFS
        processing_coordinates.add(new int[]{0,0});
        visited[0][0]=true;
        int path_len=1;
        
        if(grid[0][0]==1){
            return -1;
        }
        
        int[][] directions=new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        
        while(processing_coordinates.size()>0){
            int coordinate_count = processing_coordinates.size();
            
            while(coordinate_count>0){
                coordinate_count--;
                int[] coordinate = processing_coordinates.poll();
                int row=coordinate[0];
                int col=coordinate[1];
                
                if(row == rows-1 && col==cols-1){
                    return path_len;
                }
                
                for(int[] direction:directions){
                    int x_dir=direction[0];
                    int y_dir=direction[1];
                    int next_row=row+x_dir;
                    int next_col=col+y_dir;
                    if(isValid(next_row,next_col,rows,cols) && !visited[next_row][next_col]
                      && grid[next_row][next_col]==0){
                        visited[next_row][next_col]=true;
                        processing_coordinates.add(new int[]{next_row,next_col});
                    }
                }
            }
            path_len++;
        }
        return -1;
    }
    
    boolean isValid(int x, int y, int rows, int cols){
        return x>=0 && x<rows && y>=0 && y<cols;
    }
}