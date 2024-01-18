class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int[] dp = new int[nums.length];
        
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = 1+dp[i-1];
            }
            count+=dp[i];
        }
        
        return count;
    }
}