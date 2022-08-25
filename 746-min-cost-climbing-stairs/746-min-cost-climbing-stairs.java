class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        int[] dp=new int[len];
        for(int i=len-1;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            dp[i]=Math.min(dp[i],cost[i]+ (i+1<len?dp[i+1]:0));    
            dp[i]=Math.min(dp[i],cost[i]+ (i+2<len?dp[i+2]:0));
            // System.out.println(dp[i]);
        }
        return Math.min(dp[0],dp[1]);
    }
}