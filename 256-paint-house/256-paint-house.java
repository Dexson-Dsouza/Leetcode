class Solution {
    public int minCost(int[][] costs) {
        int totalHouse=costs.length;
        int totalColors=costs[0].length;
        Integer[][] costToPaint=new Integer[totalHouse][totalColors];
        
        int minCost=Integer.MAX_VALUE;
        for(int color=0;color<totalColors;color++){
            int cost = costs[0][color];
            minCost=Math.min(minCost,minimumCostToPaint(0,color,totalHouse,costs,costToPaint));
        }
        return minCost;
    }
    
    public int minimumCostToPaint(int curHouse, int curColor, int totalHouse, int[][] costs, Integer[][] costToPaint){
        if(curHouse==totalHouse){
            return 0;
        }
        if(costToPaint[curHouse][curColor]!=null){
            return costToPaint[curHouse][curColor];
        }
        
        int minCost=Integer.MAX_VALUE;
        int totalColors=costs[0].length;
        int cost = costs[curHouse][curColor];
        for(int color=0;color<totalColors;color++){
            if(color==curColor){
                continue;
            }
            minCost=Math.min(minCost, cost + minimumCostToPaint(curHouse+1,color,totalHouse,costs,costToPaint));
        }
        costToPaint[curHouse][curColor] = minCost;
        // System.out.println(curHouse+" "+curColor+" "+minCost);
        return minCost;
    }
}