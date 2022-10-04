class TicTacToe {
    int[][] board;
    public TicTacToe(int n) {
        board=new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        int rowCount=0;
        int colCount=0;
        int diagCount=0;
        int antiDiagCount=0;
        board[row][col]=player;
        int size = board.length;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==row && board[i][j]==player){
                    rowCount++;
                }          
                
                if(i==j && board[i][j]==player){
                    diagCount++;
                }
                if(i+j==size-1 && board[i][j]==player){
                    antiDiagCount++;
                }
            }
            if(board[i][col]==player){
                colCount++;
            }
            
        }
        if(rowCount==size || colCount==size || diagCount==size || antiDiagCount==size){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */