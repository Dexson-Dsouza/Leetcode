class Solution {
    public int largestRectangleArea(int[] heights) {
        int heightCount=heights.length;
        int[] leftClosestPole = new int[heightCount];
        int[] rightClosestPole = new int[heightCount];
        
        // use increasing sequences to get left and right closest and smaller poles
        
        Stack<Integer> leftPoles = new Stack<>();
        for(int i=0;i<heightCount;i++){
            int curHeight=heights[i];
            while(leftPoles.size()>0 && heights[leftPoles.peek()]>=curHeight){
                leftPoles.pop();
            }
            int leftClosestSmallerIndex = leftPoles.size()>0?leftPoles.peek()+1:0;
            leftClosestPole[i]=leftClosestSmallerIndex;
            leftPoles.add(i);
        }
        
        
        Stack<Integer> rightPoles = new Stack<>();
        for(int i=heightCount-1;i>=0;i--){
            int curHeight=heights[i];
            while(rightPoles.size()>0 && heights[rightPoles.peek()]>=curHeight){
                rightPoles.pop();
            }
            int rightClosestSmallerIndex = rightPoles.size()>0?rightPoles.peek()-1:heightCount-1;
            rightClosestPole[i]=rightClosestSmallerIndex;
            rightPoles.add(i);
        }
        
        int area=0;
        for(int i=0;i<heightCount;i++){
            area = Math.max(area, heights[i]*(rightClosestPole[i]-leftClosestPole[i]+1));
        }
        return area;
        
    }
}