class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int waterCollected=0;
        while(l<r){
            
            if(height[l]<=height[r]){
                int poleHeight = height[l];
                
                while(l<r && height[l]<=poleHeight){
                    waterCollected += poleHeight-height[l];
                    l++;
                }
            }else{
                int poleHeight = height[r];
                
                while(l<r && height[r]<=poleHeight){
                    waterCollected += poleHeight-height[r];
                    r--;
                }
            }
            
        }
        return waterCollected;
    }   
}