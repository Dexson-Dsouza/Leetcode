class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int [n];
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i] = Math.max(nums[i] , nums[i] + (i-1>=0?dp[i-1]:0));
            maxSum=Math.max(maxSum,dp[i]);
        }
        
        return maxSum;
    }
}