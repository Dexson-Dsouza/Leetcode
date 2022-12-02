class Solution {
    public int minCost(int n, int[] cuts) {
        Map<Integer,Map<Integer,Integer>> minCostMap=new HashMap<>();
        Arrays.sort(cuts);
        List<Integer> cutList=new ArrayList<>();
        cutList.add(0);
        for(int cut:cuts){
            cutList.add(cut);
        }
        cutList.add(n);
        return findMinCost(0,cutList.size()-1,cutList,minCostMap);
    }
    
    int findMinCost(int lIndex, int rIndex, List<Integer> cutList,Map<Integer,Map<Integer,Integer>> minCostMap){
        
        if(lIndex+1>=rIndex){
            return 0;
        }
        
        if(minCostMap.containsKey(lIndex) && minCostMap.get(lIndex).containsKey(rIndex)){
            return minCostMap.get(lIndex).get(rIndex);
        }
        if(minCostMap.containsKey(lIndex)==false){
            minCostMap.put(lIndex,new HashMap<>());
        }
        
        int minCostToCut = Integer.MAX_VALUE;
        
        int len = cutList.get(rIndex) - cutList.get(lIndex);
        
        for(int index = lIndex+1; index<rIndex; index++){
            
        minCostToCut = Math.min(minCostToCut, len + 
                                findMinCost(lIndex,index,cutList,minCostMap)  + 
                                findMinCost(index,rIndex,cutList,minCostMap));
        }
        
        minCostMap.get(lIndex).put(rIndex,minCostToCut);
        return minCostToCut;
    }
}