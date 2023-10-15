class Solution {
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(steps,arrLen);
        int[] dp =new int[arrLen];
        dp[0]=1;
        
        for(int step=0; step<steps;step++){
            int[] nextDp = new int[arrLen];
            for(int i=0;i<arrLen;i++){
                nextDp[i]=dp[i];
                if(i-1>=0){
                    nextDp[i]= (nextDp[i]+dp[i-1])%mod;
                }
                if(i+1<arrLen){
                    nextDp[i]= (nextDp[i] + dp[i+1])%mod;
                }
                
                nextDp[i] = nextDp[i];
                // System.out.print(nextDp[i]+" ");
            }
            // System.out.println();
            dp= nextDp;
        }
        
        return dp[0];
    }
    
    int mod = (int)(Math.pow(10,9)+7);
    
}