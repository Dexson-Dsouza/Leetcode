class Solution {
    public int minPathSum(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        
        while(pq.size()>0){
            int[] current=pq.poll();
            
            int cost=current[0];
            int row=current[1];
            int col=current[2];
            
            if(row==rows-1 && col==cols-1){
                return cost;
            }
            
            if(row+1<rows && visited[row+1][col]==false){
                visited[row+1][col]=true;
                pq.add(new int[]{cost+grid[row+1][col],row+1,col});
            }
            if(col+1<cols && visited[row][col+1]==false){
                int nr=row;
                int nc=col+1;
                visited[nr][nc]=true;
                pq.add(new int[]{cost+grid[nr][nc],nr,nc});
            }
        }
        return -1;
    }
}