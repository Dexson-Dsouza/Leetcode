class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->(a[0]-b[0]));
        Long[][] dp = new Long[n][m];
        return findMinimumDist(0,0,robot,factory,dp);
    }

    public long findMinimumDist(int rIndex, int factIndex, List<Integer>robot,
                                int[][] factory, Long[][] dp){
        if(rIndex==robot.size()){
            return 0;
        }
        
        if(factIndex == factory.length){
            return Long.MAX_VALUE;
        }
        
        if(dp[rIndex][factIndex]!=null){
            return dp[rIndex][factIndex];
        }
        
        long ans = findMinimumDist(rIndex,factIndex+1,robot,factory,dp);
        
        int cap = factory[factIndex][1];
        
        long dist = 0;
        for(int i=rIndex; i<robot.size() && i<rIndex + cap ;i++){
            dist += Math.abs(robot.get(i) - factory[factIndex][0]);
            
            long minCostToRepairHere = findMinimumDist(i+1,factIndex+1,robot,factory,dp);
            if(minCostToRepairHere!=Long.MAX_VALUE){
                ans = Math.min(ans, minCostToRepairHere+dist);
            }
            
        }
        dp[rIndex][factIndex] = ans;
        return ans;
    }
}