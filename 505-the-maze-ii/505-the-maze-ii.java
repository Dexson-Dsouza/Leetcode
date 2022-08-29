class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1]){
            return 0;
        }
        if(maze[start[0]][start[1]]==1){
            return -1;
        }
        int minimumSteps=Integer.MAX_VALUE;
        
        int rows=maze.length;
        int cols=maze[0].length;
        
        Integer[][] visited=new Integer[rows][cols];
        
        Queue<int[]> currentPoints=new LinkedList<>();
        currentPoints.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]]=1;
        int[][] dir=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        
        while(currentPoints.size()>0){
            int[] currentPoint=currentPoints.poll();
            int row=currentPoint[0];
            int col=currentPoint[1];
            // System.out.println(row+" "+col);
            
            int steps=currentPoint[2];
            
            for(int i=0;i<4;i++){
                int curRow=row;
                int curCol=col;
                int curSteps=steps;
                
                while(curRow+dir[i][0]>=0 && curRow+dir[i][0]<rows && curCol+dir[i][1]>=0 && curCol+dir[i][1]<cols &&
                     maze[curRow+dir[i][0]][curCol+dir[i][1]]!=1){
                    curRow+=dir[i][0];
                    curCol+=dir[i][1];
                    curSteps++;
                }
                
                // System.out.println(curRow+" "+curCol+" "+i);
                if(curSteps>minimumSteps){
                    continue;
                }
                if(curRow == destination[0] && curCol == destination[1]){
                    minimumSteps=Math.min(minimumSteps,curSteps);
                    continue;
                }
                if(visited[curRow][curCol]==null || visited[curRow][curCol]>curSteps){
                    visited[curRow][curCol]=curSteps;
                    currentPoints.add(new int[]{curRow,curCol,curSteps});
                }
                
            }
        }
        return minimumSteps==Integer.MAX_VALUE?-1:minimumSteps;
    }
}