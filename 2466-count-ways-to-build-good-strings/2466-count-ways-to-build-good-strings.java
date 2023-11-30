class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        dp[0]=1;
        int mod=(int)(Math.pow(10,9)+7);
        for(int i=0;i<high;i++){
            int appendOneLength = i+one;
            int appendZeroLength = i+zero;
            if(appendOneLength<=high){
                dp[appendOneLength]=(dp[appendOneLength]+dp[i])%mod;
            }
            if(appendZeroLength<=high){
                dp[appendZeroLength]=(dp[appendZeroLength]+dp[i])%mod;
            }
        }
        int validStrings = 0;
        for(int len=low;len<=high;len++){
            validStrings = (validStrings+dp[len])%mod;
        }
        return validStrings;
    }
}