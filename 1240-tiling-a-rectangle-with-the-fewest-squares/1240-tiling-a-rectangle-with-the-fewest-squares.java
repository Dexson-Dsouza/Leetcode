class Solution {
    public int tilingRectangle(int n, int m) {
        boolean[][] rect=new boolean[n][m];
        
        int[] minSquare=new int[]{Integer.MAX_VALUE};
        fillRectangle(0,0,rect,0,minSquare);
        return minSquare[0];
    }
    
    
    void fillRectangle(int r, int c, boolean[][] rect, int squares, int[] minSquare){
        int rows=rect.length;
        int cols=rect[0].length;
        
        if(squares>= minSquare[0]){
            return;
        }
        
        if(r==rows){
            minSquare[0]=Math.min(minSquare[0],squares);
            return;
        }       
        if(c==cols){
            fillRectangle(r+1,0,rect,squares,minSquare);
            return;
        }
        
        if(rect[r][c]){
            fillRectangle(r,c+1,rect,squares,minSquare);
            return;
        }
        
        for(int len=1;len<=Math.min(rows-r,cols-c);len++){
            if(isEmpty(rect,r,c,len)){
                cover(rect,r,c,len);
                fillRectangle(r,c+len,rect,1+squares,minSquare);
                uncover(rect,r,c,len);
            }else{
                break;
            }
        }
    }
    
    boolean isEmpty(boolean[][] rect, int row, int col, int size){
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(rect[i][j]){
                    return false;
                }   
            }
        }
        return true;
    }
    
    void cover(boolean[][] rect, int row, int col, int size){
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                rect[i][j]=true; 
            }
        }
    }
    
    
    void uncover(boolean[][] rect, int row, int col, int size){
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                rect[i][j]=false; 
            }
        }
    }
}