class Solution {
    public int kInversePairs(int n, int k) {
        Integer[][] dp = new Integer[n+1][k+1];
        return findPairs(n,1,k,dp);
    }
    int mod = (int)(Math.pow(10,9)+7);
    int findPairs(int n, int index, int k, Integer[][] dp){    
        if(k==0){
            return 1;
        }
        if(index>=n){
            return 0;
        }
        
        if(dp[index][k]!=null){
            return dp[index][k];
        }
        int count=0;
        for(int shift=1;shift<=Math.min(k,index);shift++){
            count = (count + findPairs(n,index+1,k-shift,dp))%mod;
        }
        count = (count + findPairs(n,index+1,k,dp))%mod;
        dp[index][k]=count;
        return count;
    }
}
// 1 2 3 4
// k=3