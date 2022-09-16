class TicTacToe {
    int[][] board;
    public TicTacToe(int n) {
        board=new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col]=player;
        boolean winsRow=true;
        for(int j=0;j<board.length;j++){
            if(board[row][j]!=player){
                winsRow=false;
            }
        }
        if(winsRow){
            return player;
        }
        boolean winsCol=true;
        for(int j=0;j<board.length;j++){
            if(board[j][col]!=player){
                winsCol=false;
            }
        }
        if(winsCol){
            return player;
        }
        
        boolean winsDiag=true;
        boolean winsAntiDiag=true;
        for(int i=0;i<board.length;i++){
            if(board[i][i]!=player){
                winsDiag=false;
            }   
            if(board[i][board.length-1-i]!=player){
                winsAntiDiag=false;
            }
        }
        if(winsDiag || winsAntiDiag){
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