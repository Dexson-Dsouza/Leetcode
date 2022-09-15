class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(search(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean search(char[][] board, String word, int index, int r, int c){
        if(index==word.length()){
            return true;
        }
        if(r<0 || r>=board.length || c<0 || c>=board[0].length){
            return false;
        }
        if(board[r][c]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()){
            return true;
        }
        char t =board[r][c];
        board[r][c]='*';
        
        boolean found = search(board,word,index+1,r+1,c) ||search(board,word,index+1,r-1,c) ||
            search(board,word,index+1,r,c+1) ||search(board,word,index+1,r,c-1);
            
        if(found){
            return true;
        }
        board[r][c]=t;
        return false;
    }
}