class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalPeople=costs.length;
        
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1]));
        
        int totalCost=0;
        for(int i=0;i<totalPeople/2;i++){
            totalCost+=costs[i][0];
        }
        for(int i=totalPeople/2;i<totalPeople;i++){
            totalCost+=costs[i][1];
        }
        return totalCost;
    }
}