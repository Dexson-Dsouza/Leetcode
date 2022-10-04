class Solution {
    public void gameOfLife(int[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1},{1,1},{-1,1}};
        
        
        int[][] nextState = new int[rows][cols];    
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int liveCount=0;
                // board[i][j]= board[i][j]==1?-1:-2;
                int currentState= board[i][j];
                for(int dir=0;dir<8;dir++){
                    int nr=i+directions[dir][0];
                    int nc=j+directions[dir][1];

                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && Math.abs(board[nr][nc])==1){
                        liveCount++;
                    }
                }

                if(currentState==1 && (liveCount<2 || liveCount>3)){
                    currentState=-1;
                }
                if(currentState==0 && liveCount==3){
                    currentState=2;
                }
                board[i][j]=currentState;
            }
        }    
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]>0){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }
    }
}