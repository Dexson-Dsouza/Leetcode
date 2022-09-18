class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int rows=board.length;
        int cols=board[0].length;
        
        int clickX=click[0];
        int clickY=click[1];
        
        if(board[clickX][clickY]=='M'){
            board[clickX][clickY]='X';
        }else{
            boolean[][] visited=new boolean[rows][cols];
            reveal(board,visited,clickX,clickY,rows,cols);
        }
        return board;
    }
    
    int[][] dirs=new int[][]{{0,1},{-1,-1},{-1,0},{-1,1},{0,-1},{1,-1},{1,0},{1,1}};
    
    public void reveal(char[][] board, boolean[][] visited, int r, int c, int rows, int cols){
        visited[r][c]=true;
        if(board[r][c]!='E'){
            return;
        }
        
        int bombCount=0;
        for(int i=0;i<8;i++){
            int nr=r+dirs[i][0];
            int nc=c+dirs[i][1];
            if(nr<0 || nr>=rows || nc<0 || nc>=cols){
                continue;
            }
            if(board[nr][nc]=='M'){
                bombCount++;
            }
        }
        
        if(bombCount==0){
            board[r][c]='B';
            for(int i=0;i<8;i++){
                int nr=r+dirs[i][0];
                int nc=c+dirs[i][1];
                if(nr<0 || nr>=rows || nc<0 || nc>=cols){
                    continue;
                }
                if(visited[nr][nc]==false){
                    reveal(board,visited,nr,nc,rows,cols);
                }
            }
        }else{
            board[r][c]=(char)('0'+bombCount);
        }
        // System.out.println(r+" "+c+" "+board[r][c]);
    }
}
// [["B","1","E","E","E"]
// ,["B","1","M","E","E"]
// ,["B","1","E","E","E"],
//  ["B","B","E","E","E"]]
 



