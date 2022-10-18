class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        for(int row=0;row<rows;row++){
            int rowBit=0;
            for(int col=0;col<cols;col++){
                if(board[row][col]!='.'){
                    int num=board[row][col]-'0';
                    if((rowBit&(1<<num))!=0){
                        return false;
                    }
                    rowBit|=(1<<num);
                }
            }
        }
        
        for(int col=0;col<cols;col++){
            int colBit=0;
            for(int row=0;row<rows;row++){
                if(board[row][col]!='.'){
                    int num=board[row][col]-'0';
                    if((colBit&(1<<num))!=0){
                        return false;
                    }
                    colBit|=(1<<num);
                }
            }
        }
        
        for(int row=0;row<rows;row+=3){
            for(int col=0;col<cols;col+=3){
                int blockBit=0;
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                       if(board[i][j]!='.'){
                            int num=board[i][j]-'0';
                            if((blockBit&(1<<num))!=0){
                                return false;
                            }
                            blockBit|=(1<<num);
                        } 
                    }
                }
                
            }
        }
        return true;
    }
}