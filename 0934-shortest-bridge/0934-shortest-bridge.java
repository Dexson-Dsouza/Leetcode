class Solution {
    public int shortestBridge(int[][] grid) {
        int first_x = -1, first_y = -1;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i=0;i<rows && first_x==-1;i++){
            for(int j=0;j<cols && first_x==-1;j++){
                if(grid[i][j]==1){
                    first_x=i;
                    first_y=j;
                }
            }
        }
        
        Queue<int[]> coords = new LinkedList<>();
        //get first island coordinates
        get_first_island(grid,first_x,first_y,coords);
        
        // bfs first island untill we get other island
        
        int flip_count = 0;
        boolean found_other_island = false;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(coords.size()>0 && !found_other_island){
            flip_count++;
            int queue_size = coords.size();
            while(queue_size>0){
                queue_size--;
                int x = coords.peek()[0];
                int y = coords.peek()[1];
                coords.poll();
                
                for(int[] dir:directions){
                    int next_x = x + dir[0];
                    int next_y = y + dir[1];
                    if(isInvalid(next_x,next_y,grid)  || grid[next_x][next_y]<0){
                        continue;
                    }
                    
                    if(grid[next_x][next_y]==1){
                        return flip_count-1;
                    }
                    grid[next_x][next_y]=-2;
                    coords.add(new int[]{next_x,next_y});
                }
            }
            
        }
        return -1;
    }
    
    public void get_first_island(int[][] grid, int x, int y, Queue<int[]> coords){
        if(isInvalid(x,y,grid) || grid[x][y]!=1){
            return;
        }
        grid[x][y] = -grid[x][y];
        coords.add(new int[]{x,y});
        get_first_island(grid,x+1,y,coords);
        get_first_island(grid,x,y+1,coords);
        get_first_island(grid,x-1,y,coords);
        get_first_island(grid,x,y-1,coords);
    }
    
    boolean isInvalid(int x,int y, int[][] grid){
        return x<0 || x>=grid.length || y<0 || y>=grid[0].length;
    }
}