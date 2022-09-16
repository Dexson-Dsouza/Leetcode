class TicTacToe {
    int[][] board;
    public TicTacToe(int n) {
        board=new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col]=player;
        for(int i=0;i<board.length;i++){
            boolean wins=true;
            for(int j=0;j<board.length;j++){
                if(board[i][j]!=player){
                    wins=false;
                }
            }
            if(wins){
                return player;
            }
        }
        
        for(int i=0;i<board.length;i++){
            boolean wins=true;
            for(int j=0;j<board.length;j++){
                if(board[j][i]!=player){
                    wins=false;
                }
            }
            if(wins){
                return player;
            }
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