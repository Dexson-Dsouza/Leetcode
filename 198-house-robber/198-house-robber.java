class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        
        for(int i=nums.length-1;i>=0;i--){
            dp[i]=Math.max(dp[i],nums[i]+ (i+2<nums.length?dp[i+2]:0));
            dp[i]=Math.max(dp[i],(i+1<nums.length?dp[i+1]:0));
        }
        return dp[0];
    }
}