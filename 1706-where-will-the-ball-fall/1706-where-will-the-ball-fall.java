class Solution {
    public int[] findBall(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        
        int[] answer=new int[cols];
        Arrays.fill(answer,-1);
        
        for(int col=0;col<cols;col++){
            int curCol=col;
            int curRow=0;
            while(curRow<rows){
                
                int curValue = grid[curRow][curCol];
                if(curValue==1){
                    if(curCol+1>=cols || grid[curRow][curCol+1]==-1){
                        break;
                    }
                    curCol++;
                }else if(curValue==-1){
                    if(curCol-1<0 || grid[curRow][curCol-1]==1){
                        break;
                    }
                    curCol--;
                }
                curRow++;
            }
            
            if(curRow==rows){
                answer[col]=curCol;
            }
        }
        
        return answer;
    }
}