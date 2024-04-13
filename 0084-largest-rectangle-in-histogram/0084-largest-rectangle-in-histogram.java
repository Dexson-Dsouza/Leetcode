class Solution {
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