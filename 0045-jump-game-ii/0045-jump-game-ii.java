class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;j<=nums[i];j++){
                int jump = Math.min(i+j,nums.length-1);
                dp[jump] = Math.min(dp[jump],1+dp[i]);
            }
        }
        return dp[nums.length-1];
    }
}