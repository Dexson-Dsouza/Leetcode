class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int coins = prob.length;
        double[][] dp = new double[coins+1][target+1];
        dp[0][0]=1;
        for(int coin = 1;coin<=coins;coin++){
            for(int curTarget = 0;curTarget<=target;curTarget++){
                double headProb = prob[coin-1];
                double tailProb = 1 - headProb;
                dp[coin][curTarget] = dp[coin-1][curTarget]*tailProb;
                
                if(curTarget>0){
                    dp[coin][curTarget] += dp[coin-1][curTarget-1]*headProb;
                }
                
                // System.out.println(coin + " "+curTarget+" "+ dp[coin][curTarget]);
            }
        }
        return dp[coins][target];
    }
}