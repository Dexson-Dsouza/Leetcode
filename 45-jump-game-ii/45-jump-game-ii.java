class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        
        for(int i=n-2;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i+1;j<=Math.min(n-1,i+nums[i]);j++){
                if(dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[j]);
                }
            }
        }
        return dp[0];
    }
}