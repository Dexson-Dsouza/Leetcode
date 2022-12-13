/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(matrix) {
    let rows = matrix.length;
    let cols = matrix[0].length;
    
    for(let row = 1; row < rows; row++){
        for(let col = 0; col < cols; col++){
            let prevRow = row-1;
            let curCost = matrix[row][col];
            let minCost = matrix[prevRow][col] + curCost;
            
            if(col-1>=0){
                minCost = Math.min(minCost, curCost + matrix[prevRow][col-1]);
            }
            
            if(col+1<cols){
                minCost = Math.min(minCost, curCost + matrix[prevRow][col+1]);
            }
            matrix[row][col] = minCost;
        }    
    }
    
    let minPathSum = Infinity;
    
    for(let i=0;i<cols;i++){
        minPathSum = Math.min(minPathSum, matrix[rows-1][i]);
    }
    return minPathSum;
};