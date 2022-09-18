class Solution {
    public int trap(int[] heights) {
        int l=0;
        int r=heights.length-1;
        while(l<r && heights[l]==0){
            l++;
        }
        while(l<r && heights[r]==0){
            r--;
        }
        
        int totalCap=0;
        
        while(l<r){
            if(heights[l]<=heights[r]){
                int curHeight=heights[l];
                l++;
                int curCap=0;
                while(l<r && heights[l]<curHeight){
                    curCap+=curHeight-heights[l];
                    l++;
                }
                totalCap+=curCap;
            }else{
                int curHeight=heights[r];
                r--;
                int curCap=0;
                while(l<r && heights[r]<curHeight){
                    curCap+=curHeight-heights[r];
                    r--;
                }
                totalCap+=curCap;
            }
        }
        return totalCap;
    }
}