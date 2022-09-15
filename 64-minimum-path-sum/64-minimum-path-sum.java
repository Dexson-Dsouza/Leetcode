class Solution {
    public int minPathSum(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        int[][] minCost=new int[rows][cols];
        return findCost(grid,0,0,minCost,visited);
    }
    
    int findCost(int[][] grid, int row, int col, int[][] minCost, boolean[][] visited){
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        if(visited[row][col]==true){
            return minCost[row][col];
        }
        visited[row][col]=true;
        int minCostToReach=Integer.MAX_VALUE;
        if(row+1 < grid.length){
            minCostToReach=Math.min(minCostToReach, grid[row][col] + findCost(grid,row+1,col,minCost,visited));
        }
        if(col+1 < grid[0].length){
            minCostToReach=Math.min(minCostToReach, grid[row][col] + findCost(grid,row,col+1,minCost,visited));
        }
        return minCost[row][col]=minCostToReach;
    }
}