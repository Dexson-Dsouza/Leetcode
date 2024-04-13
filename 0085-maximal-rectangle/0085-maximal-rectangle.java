class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        
        int[][] rowSumMat = new int[rows+1][cols+1];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    rowSumMat[i+1][j+1] = 1+rowSumMat[i][j+1];
                }
            }
        }
        
        int maxArea=0;
        for(int i=0;i<rows;i++){
            for(int h=1;h<=i+1;h++){
                int curArea=0;
                for(int j=0;j<cols;j++){
                    if(rowSumMat[i+1][j+1]>=h){
                        curArea+=h;
                    }else{
                        curArea=0;
                    }
                    // System.out.println(i+" "+j+" "+h+" "+curArea);
                    maxArea=Math.max(curArea,maxArea);
                }
            }
        }
        return maxArea;
    }
}