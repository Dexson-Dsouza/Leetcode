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
            maxArea=Math.max(maxArea,largestRectangleArea(rowSumMat[i+1]));
        }
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
      int n = heights.length;
      Stack<Integer> stack = new Stack();
      int maxArea = 0;
      for(int i = 0; i <= n; i++){
        int h = i == n ? 0 : heights[i];
        while(!stack.isEmpty() && h < heights[stack.peek()]){
          int curHeight = heights[stack.pop()];
          int prevIndex = stack.isEmpty() ? -1 : stack.peek();
          int area = curHeight * (i - prevIndex - 1);
          maxArea = Math.max(maxArea, area);
        }
        stack.push(i);
      }
      return maxArea;  
    }
}