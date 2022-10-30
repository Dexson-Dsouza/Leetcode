class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows=grid.length;
        int cols=grid[0].length;
        Set<String> visitedStates=new HashSet<>();
        Queue<int[]> currentStates=new LinkedList<>();
        currentStates.add(new int[]{0,0,k,0});
        String startKey = 0+"*"+0+"*"+k;
        visitedStates.add(startKey);
        int[] dirs=new int[]{0,-1,0,1,0};
        int minimumMoves=Integer.MAX_VALUE;
        boolean[][][] movesToReach=new boolean[rows][cols][k+1];
        movesToReach[0][0][0]=true;
        while(currentStates.size()>0){
            int[] currentState=currentStates.poll();
            
            int row=currentState[0];
            int col=currentState[1];
            int kCount=currentState[2];
            int moves=currentState[3];
            if(row==rows-1 && col==cols-1){
                minimumMoves=Math.min(minimumMoves,moves);
                continue;
            }
            for(int i=0;i<4;i++){
                int nextRow=row+dirs[i];
                int nextCol=col+dirs[i+1];
                if(nextRow>=0 && nextRow<rows && nextCol>=0 && nextCol<cols && kCount>=grid[nextRow][nextCol]){
                    int remCount=kCount-grid[nextRow][nextCol];
                    String stateKey = nextRow+"*"+nextCol+"*"+remCount;
                    if(movesToReach[nextRow][nextCol][remCount]==false){
                        movesToReach[nextRow][nextCol][remCount]=true;

                        // System.out.println(stateKey);
                        currentStates.add(new int[]{nextRow,nextCol,remCount,moves+1});
                    }
                }

            }
        }
        return minimumMoves==Integer.MAX_VALUE?-1:minimumMoves;
    }
}