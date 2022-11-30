class NumMatrix {
    int[][] colSum;
    int rows;
    int cols;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        rows=matrix.length;
        cols=matrix[0].length;
        colSum = new int[rows+1][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0;j<cols;j++){
                colSum[i][j] = colSum[i-1][j] + matrix[i-1][j];
            }
        }
        this.matrix=matrix;
    }
    
    public void update(int row, int col, int val) {
        
        int diff = val - matrix[row][col];
        for(int i=row+1;i<=rows;i++){
            colSum[i][col] = colSum[i][col] + diff;
        }
        matrix[row][col]=val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0;
        
        for(int i=col1;i<=col2;i++){
            sum += colSum[row2+1][i]-colSum[row1][i];
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */