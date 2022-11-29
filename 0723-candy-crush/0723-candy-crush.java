class Solution {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        boolean crushed=false;
        do{
            crushed=false;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    int row = i;
                    int col = j;
                    
                    if(board[row][col]==0){
                        continue;
                    }
                    
                    // check right side
                    int columnCandyCount = crushedColumnCandies(board,row,col,rows,cols);
                    if(columnCandyCount>2){
                        crushed=true;
                    }
                    
                    // check bottom side
                    
                    int rowCandyCount = crushedRowCandies(board,row,col,rows,cols);
                    if(rowCandyCount>2){
                        crushed=true;
                    }
                }
            }
            if(crushed){
                shuffleCrushedCandies(board,rows,cols);
            }
        }while(crushed);
        return board;
    }
    
    public int crushedColumnCandies(int[][] board, int row, int col, int rows, int cols){
        int currentCandy = Math.abs(board[row][col]);
        int nextCol = col;
        int crushedCandyCount = 0;
        while(nextCol<cols && Math.abs(board[row][nextCol]) == currentCandy){
            crushedCandyCount++;
            nextCol++;
        }

        if(crushedCandyCount>2){
            nextCol = col;
            while(nextCol<cols && Math.abs(board[row][nextCol]) == currentCandy){
                if(board[row][nextCol]>0){
                    board[row][nextCol]*=-1;
                }
                nextCol++;
            }   
        }
        return crushedCandyCount;
    }
    
    public int crushedRowCandies(int[][] board, int row, int col, int rows, int cols){
        int currentCandy = Math.abs(board[row][col]);
        int nextRow = row;
        int crushedCandyCount = 0;
        while(nextRow < rows && Math.abs(board[nextRow][col]) == currentCandy){
            crushedCandyCount++;
            nextRow++;
        }

        if(crushedCandyCount>2){
            nextRow = row;
            while(nextRow < rows && Math.abs(board[nextRow][col]) == currentCandy){
                if(board[nextRow][col]>0){
                    board[nextRow][col]*=-1;
                }
                nextRow++;
            }   
        }
        return crushedCandyCount;
    }
    
    public void shuffleCrushedCandies(int[][] board, int rows, int cols){
        for(int col=0;col<cols;col++){
            int currentRow = rows-1;
            int CandyPointer = rows-1;
            while(CandyPointer>=0){
                while(CandyPointer>=0 && board[CandyPointer][col]<=0){
                    CandyPointer--;
                }
                if(CandyPointer<0){
                    break;
                }
                board[currentRow][col] = board[CandyPointer][col];
                currentRow--;
                CandyPointer--;
            }
            
            while(currentRow>=0 ){
                board[currentRow][col] = 0;
                currentRow--;
            }
        }
    }
}