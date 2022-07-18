class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                
                if(matrix[row][col]==0){
                    continue;
                }
                int left = col>0 ? matrix[row][col-1]:0;
                int top = row>0 ? matrix[row-1][col]:0;
                int topLeft = col>0 && row>0 ? matrix[row-1][col-1]:0;
                
                matrix[row][col] = 1+ Math.min(left , Math.min(top,topLeft));
                count+=matrix[row][col];
            }
        }
        return count;
    }
}