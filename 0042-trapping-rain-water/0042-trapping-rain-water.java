class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        int left = 0;
        int right = size - 1;
        
        while(left<right){
            if(height[left]<=height[right]){
                //check left bar
                int index = left;
                while(index<right && height[index]<=height[left]){
                    ans += height[left] - height[index]; 
                    index++;
                }
                left = index;
            }else{
                //check right bar
                int index = right;
                while(index>left && height[index]<=height[right]){
                    ans += height[right] - height[index]; 
                    index--;
                }
                right = index;
            }
        }
        return ans;
    }
}