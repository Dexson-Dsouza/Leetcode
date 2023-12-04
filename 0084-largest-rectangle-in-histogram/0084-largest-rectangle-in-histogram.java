class Solution {
    public static int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] closestLessFromLeft = new int[height.length]; 
        // index of the first bar the left that is lower than current
        
        int[] closestLessFromRight = new int[height.length]; 
        // index of the first bar the right that is lower than current
        
        closestLessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int closestIndex = i - 1;

            while (closestIndex >= 0 && height[closestIndex] >= height[i]) {
                closestIndex = closestLessFromLeft[closestIndex];
            }
            closestLessFromLeft[i] = closestIndex;
        }
        
        
        closestLessFromRight[height.length - 1] = height.length;

        for (int i = height.length - 2; i >= 0; i--) {
            int closestIndex = i + 1;

            while (closestIndex < height.length && height[closestIndex] >= height[i]) {
                closestIndex = closestLessFromRight[closestIndex];
            }
            closestLessFromRight[i] = closestIndex;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * 
                               (closestLessFromRight[i] - closestLessFromLeft[i] - 1));
        }

        return maxArea;
    }
}