class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        
        int l=0;
        int r=Integer.MAX_VALUE;
        int minimumDiff = Integer.MAX_VALUE;
        
        while(l<=r){
            // target Diff
            int mid=l+(r-l)/2;
            
            // find pairs with target_diff
            int count = p;
            
            for(int i=1;i<nums.length;i++){
                if(nums[i]-nums[i-1]<=mid){
                    count--;
                    i++;
                }
            }
            
            if(count<=0){
                minimumDiff=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return minimumDiff;
    }
}