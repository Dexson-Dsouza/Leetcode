class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        
        int[][] indeg=new int[rows][cols];
        int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}}; 
        
        Queue<int[]> currentPoints=new LinkedList<>();
        
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                int currentVal= matrix[row][col];
                for(int dir=0;dir<4;dir++){
                    int neighbourRow= row + directions[dir][0];
                    int neighbourCol= col + directions[dir][1];
                    
                    if(isValid(rows,cols,neighbourRow,neighbourCol) && matrix[neighbourRow][neighbourCol]>currentVal){
                        indeg[row][col]++;
                    }
                }
                
                if(indeg[row][col]==0){
                    currentPoints.add(new int[]{row,col});
                }
            }
        }
        
        int longestLength=0;
        
        while(currentPoints.size()>0){
            longestLength++;
            int size=currentPoints.size();
            for(int point=0;point<size;point++){
                int[] currentPoint=currentPoints.poll();
                int row=currentPoint[0];
                int col=currentPoint[1];
                int currentVal= matrix[row][col];
                for(int dir=0;dir<4;dir++){
                    int neighbourRow= row + directions[dir][0];
                    int neighbourCol= col + directions[dir][1];
                    
                    if(isValid(rows,cols,neighbourRow,neighbourCol) && matrix[neighbourRow][neighbourCol]<currentVal){
                        indeg[neighbourRow][neighbourCol]--;
                        if(indeg[neighbourRow][neighbourCol]==0){
                            currentPoints.add(new int[]{neighbourRow,neighbourCol});
                        }
                    }
                }
            }
        }
        return longestLength;
    }
    
    
    boolean isValid(int rows, int cols, int r, int c){
        return r>=0 && r<rows && c>=0 && c<cols;
    }
}