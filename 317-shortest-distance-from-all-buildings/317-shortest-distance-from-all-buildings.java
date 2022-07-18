class Solution {
    public int shortestDistance(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        
        int[][] dist=new int[rows][cols];
        
        int[][] reached=new int[rows][cols];
        
        
        int countOfBldgs=0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    countOfBldgs++;
                    findDist(grid,row,col,dist,reached);
                }
            }
        }
        
        
        
        int minimumDist=Integer.MAX_VALUE;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==0 && reached[row][col]==countOfBldgs){
                    minimumDist=Math.min(minimumDist,dist[row][col]);
                }
            }
        }
        return minimumDist==Integer.MAX_VALUE?-1:minimumDist;
    }
    
    int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    void findDist(int[][] grid, int r, int c, int[][] dist,int[][] reached){
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        Queue<int[]> currentPoints=new LinkedList<>();
        currentPoints.add(new int[]{r,c});
        int currentDist=0;
        while(currentPoints.size()>0){
            int size=currentPoints.size();
            currentDist++;
            for(int i=0;i<size;i++){
                int row=currentPoints.peek()[0];
                int col=currentPoints.peek()[1];
                currentPoints.poll();
                for(int direction=0; direction<4;direction++){
                    int nextRow=row + directions[direction][0];
                    int nextCol=col + directions[direction][1];
                    if(isValid(nextRow,nextCol,rows,cols) && grid[nextRow][nextCol]==0 && visited[nextRow][nextCol]==false){
                        dist[nextRow][nextCol] += currentDist;
                        visited[nextRow][nextCol] = true;
                        currentPoints.add(new int[]{nextRow,nextCol});
                        reached[nextRow][nextCol]++;
                    }
                }
            }
        }
        
    }
    
    boolean isValid(int r,int c, int rows, int cols){
        return r>=0 && r<rows && c>=0 && c<cols;
    }
}