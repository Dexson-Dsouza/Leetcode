class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;
        
        int curSum=0;
        
        for(int i=0;i<n;i++){
            curSum = Math.max(nums[i] , nums[i] + curSum);
            maxSum=Math.max(maxSum,curSum);
        }
        
        return maxSum;
    }
}