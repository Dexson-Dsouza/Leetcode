class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp= new boolean[nums.length+1];
        dp[0]=true;
        
        for(int i=1;i<nums.length;i++){
            
            
            
            if(nums[i]==nums[i-1]){
                // check 2 same
                dp[i+1]|=dp[i-1];
            }
            
            // check 3 same
            
            if(i>1 && nums[i]==nums[i-1] && nums[i]==nums[i-2]){
                dp[i+1]|=dp[i-2];
            }
            
            // check consecutive
            
            if(i>1 && (nums[i]-1)==nums[i-1] && (nums[i]-2)==nums[i-2]){
                dp[i+1]|=dp[i-2];
            }
        }
        return dp[nums.length];
    }
}