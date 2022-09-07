class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int totalSteps=cost.length;
        int[] costToReach=new int[totalSteps];
        
        for(int i=totalSteps-1;i>=0;i--){
            costToReach[i]=cost[i] + Math.min((i+1<totalSteps?costToReach[i+1]:0),(i+2<totalSteps?costToReach[i+2]:0));
        }
        return Math.min(costToReach[0],costToReach[1]);
    }
}