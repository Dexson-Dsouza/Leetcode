class Solution {
    public int minCost(int n, int[] cuts) {
        Map<Integer,Map<Integer,Integer>> minCostMap=new HashMap<>();
        Arrays.sort(cuts);
        return findMinCost(0,n,cuts,0,cuts.length-1,minCostMap);
    }
    
    int findMinCost(int startPoint, int endPoint, int[] cuts, int lIndex, int rIndex,
                    Map<Integer,Map<Integer,Integer>> minCostMap){
        int len = endPoint-startPoint;
        
        if(lIndex>rIndex){
            return 0;
        }
        if(lIndex==rIndex){
            return len;
        }
        
        if(minCostMap.containsKey(lIndex) && minCostMap.get(lIndex).containsKey(rIndex)){
            return minCostMap.get(lIndex).get(rIndex);
        }
        if(minCostMap.containsKey(lIndex)==false){
            minCostMap.put(lIndex,new HashMap<>());
        }
        
        int minCostToCut = Integer.MAX_VALUE;
        
        for(int index = lIndex; index<=rIndex; index++){
            
            int leftLen = cuts[index] - startPoint;
            
            minCostToCut = Math.min(minCostToCut, 
                                    len + 
                                    findMinCost(startPoint,cuts[index],cuts,lIndex,index-1,minCostMap) +
                                    findMinCost(cuts[index],endPoint,cuts,index+1,rIndex,minCostMap));
        }
        
        minCostMap.get(lIndex).put(rIndex,minCostToCut);
        return minCostToCut;
    }
}