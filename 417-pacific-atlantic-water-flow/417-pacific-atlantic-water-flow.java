class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        
        boolean[][] canReachPacific=new boolean[rows][cols];
        boolean[][] visitedPointsPacific=new boolean[rows][cols];
        
        for(int i=0;i<cols;i++){
            expand(heights,0,i,rows,cols,canReachPacific,visitedPointsPacific);
        }
        for(int i=0;i<rows;i++){
            expand(heights,i,0,rows,cols,canReachPacific,visitedPointsPacific);
        }
        
        boolean[][] canReachAtlantic=new boolean[rows][cols];
        boolean[][] visitedPointsAtlantic=new boolean[rows][cols];
        
        for(int i=0;i<cols;i++){
            expand(heights,rows-1,i,rows,cols,canReachAtlantic,visitedPointsAtlantic);
        }
        for(int i=0;i<rows;i++){
            expand(heights,i,cols-1,rows,cols,canReachAtlantic,visitedPointsAtlantic);
        }
        
        List<List<Integer>> canReachBothPoints=new ArrayList<>();
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(canReachPacific[row][col]==true && canReachAtlantic[row][col]==true){
                    List<Integer> point=new ArrayList<>();
                    point.add(row);
                    point.add(col);
                    canReachBothPoints.add(point);
                }
            }
        }
        return canReachBothPoints;
    }
    
    void expand(int[][] heights, int r, int c, int rows, int cols, boolean[][] canReach, boolean[][] visited){
        canReach[r][c]=true;
        visited[r][c]=true;
        int[] dir={0,-1,0,1,0};
        
        for(int i=0;i<4;i++){
            int nr=r+dir[i];
            int nc=c+dir[i+1];
            if(nr>=0 && nr<rows && nc>=0 && nc<cols && heights[nr][nc]>=heights[r][c] && visited[nr][nc]==false){
                expand(heights,nr,nc,rows,cols,canReach,visited);
            }
        }
    }
}