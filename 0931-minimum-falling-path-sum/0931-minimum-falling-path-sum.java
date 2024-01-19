class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        
        // fill first row
        for(int i=0;i<cols;i++){
            dp[0][i]=matrix[0][i];
        }
        
        // fill other rows
        
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                int cur_value = matrix[i][j];
                int prev_best = dp[i-1][j];
                if(j-1>=0){
                    prev_best = Math.min(prev_best,dp[i-1][j-1]);
                }
                if(j+1<cols){
                    prev_best = Math.min(prev_best,dp[i-1][j+1]);
                }
                dp[i][j] = cur_value + prev_best;
            }
        }
        
        int lowest_sum = Integer.MAX_VALUE;
        
        for(int i=0;i<cols;i++){
            lowest_sum = Math.min(lowest_sum,dp[rows-1][i]);
        }
        return lowest_sum;
    }
}