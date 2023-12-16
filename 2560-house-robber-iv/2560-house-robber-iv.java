class Solution {
    public int minCapability(int[] nums, int k) {
        int l=0;
        int r=Integer.MAX_VALUE;
        
        int minCap = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int count = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    count++;
                    i++;
                }
            }
            if(count>=k){
                r=mid-1;
                minCap = mid;
            }else{
                l=mid+1;
            }
        }
        return minCap;
    }
}