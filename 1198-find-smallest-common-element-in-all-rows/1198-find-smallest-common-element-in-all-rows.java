class Solution {
    public int smallestCommonElement(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        
        int[] indexes=new int[rows];
        boolean canFind=true;
        while(canFind){
            int largest=-1;
            for(int row=0;row<rows;row++){
                int col=indexes[row];
                int curVal = mat[row][col];
                largest = Math.max(largest,curVal);
            }
            int count = 0;
            for(int row = 0; row < rows; row++){
                int col=indexes[row];
                int curVal = mat[row][col];
                if(curVal==largest){
                    count++;
                }else{
                    while(col<cols && mat[row][col]<largest){
                        col++;
                    }
                    if(col==cols){
                        canFind=false;
                    }
                    indexes[row]=col;
                }
            }
            
            if(count==rows){
                return largest;
            }
        }
        return -1;
    }
}