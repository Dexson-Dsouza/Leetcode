class Solution {
    public int minCost(int n, int[] cuts) {
        Map<Integer,Map<Integer,Integer>> minCostMap=new HashMap<>();
        Arrays.sort(cuts);
        return findMinCost(0,n,cuts,0,cuts.length-1,minCostMap);
    }
    
    int findMinCost(int start, int end, int[] cuts, int l, int r, Map<Integer,Map<Integer,Integer>> minCostMap){
        int len = end-start;
        
        if(l>r){
            return 0;
        }
        if(l==r){
            return len;
        }
        
        if(minCostMap.containsKey(len) && minCostMap.get(len).containsKey(l)){
            return minCostMap.get(len).get(l);
        }
        if(minCostMap.containsKey(len)==false){
            minCostMap.put(len,new HashMap<>());
        }
        
        int minCostToCut = Integer.MAX_VALUE;
        
        for(int index = l; index<=r; index++){
            
            int leftLen = cuts[index] - start;
            
            minCostToCut = Math.min(minCostToCut, 
                                    len + 
                                    findMinCost(start,cuts[index],cuts,l,index-1,minCostMap) +
                                    findMinCost(cuts[index],end,cuts,index+1,r,minCostMap));
        }
        
        minCostMap.get(len).put(l,minCostToCut);
        return minCostToCut;
    }
}