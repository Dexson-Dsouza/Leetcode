class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
    
    public int rob(int[] nums, int s, int e){
        if(s>e){
            return 0;
        }
        int[] dp=new int[nums.length];
        for(int i=s;i<=e;i++){
            dp[i] = Math.max(nums[i] + (i-2>=s?dp[i-2]:0), i-1>=s?dp[i-1]:0);
        }
        return dp[e];
    }
}