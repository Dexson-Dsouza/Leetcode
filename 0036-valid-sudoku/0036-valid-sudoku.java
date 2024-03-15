class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        
        for(int row=0;row<rows;row++){
            HashSet<Integer> rowSet = new HashSet<Integer>();
            for(int col=0;col<cols;col++){
                if(board[row][col]!='.'){
                    int num=board[row][col]-'0';
                    if(rowSet.contains(num)){
                        return false;
                    }
                    rowSet.add(num);
                }
            }
        }
        
        for(int col=0;col<cols;col++){
            HashSet<Integer> columnSet = new HashSet<Integer>();
            for(int row=0;row<rows;row++){
                if(board[row][col]!='.'){
                    int num=board[row][col]-'0';
                    if(columnSet.contains(num)){
                        return false;
                    }
                    columnSet.add(num);
                }
            }
        }
        
        
        for(int row=0;row<rows;row+=3){
            for(int col=0;col<cols;col+=3){
                HashSet<Integer> cubeSet = new HashSet<Integer>();
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                       if(board[i][j]!='.'){
                            int num=board[i][j]-'0';
                            if(cubeSet.contains(num)){
                                return false;
                            }
                            cubeSet.add(num);
                        } 
                    }
                }
                
            }
        }
        return true;
    }
}