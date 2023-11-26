class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int j=0;j<cols;j++){
            for(int i=1;i<rows;i++){
                matrix[i][j]=matrix[i][j]==0?0:matrix[i-1][j]+matrix[i][j];
            }
        }
        
        int maxArea=0;
        
        for(int i=0;i<rows;i++){
            int[] curRow = matrix[i];
            Arrays.sort(curRow);
            for(int j=cols-1;j>=0;j--){
                maxArea = Math.max(maxArea,curRow[j]*(cols-j));
            }
        }
        return maxArea;
    }
}