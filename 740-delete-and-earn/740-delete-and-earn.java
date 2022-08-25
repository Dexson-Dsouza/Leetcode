class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxElement=0;
        for(int n:nums){
            maxElement=Math.max(maxElement,n);
        }
        
        int[] cnt=new int[maxElement+1];
        int[] dp=new int[maxElement+1];
        
        for(int n:nums){
            cnt[n]++;
        }
        
        for(int i=maxElement;i>=1;i--){
            dp[i]=Math.max(cnt[i]*i + (i+2<=maxElement?dp[i+2]:0) , (i+1<=maxElement?dp[i+1]:0));
        }
        return dp[1];
    }
}