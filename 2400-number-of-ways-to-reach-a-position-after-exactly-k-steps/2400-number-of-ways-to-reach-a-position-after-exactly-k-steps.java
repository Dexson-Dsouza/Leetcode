class Solution {
    private int mod = (int)(Math.pow(10,9)+7);
    
    public int numberOfWays(int startPos, int endPos, int k) {
        Map<Integer,Map<Integer,Integer>> positionStepMap=new HashMap<>();
        return findAllWays(startPos,endPos,k,positionStepMap);
    }
    
    public int findAllWays(int startPos, int endPos, int k, Map<Integer,
                           Map<Integer,Integer>> positionStepMap){
        if(k==0){
            return startPos==endPos?1:0;
        }
        
        // String positionKey = startPos+"_"+k;
        if(positionStepMap.containsKey(startPos) &&
           positionStepMap.get(startPos).containsKey(k)){
            return positionStepMap.get(startPos).get(k);
        }
        
        int steps=0;
        int distance = Math.abs(endPos-startPos);
        if(distance<=k){
            int takeLeft = findAllWays(startPos-1,endPos,k-1,positionStepMap);
            int takeRight = findAllWays(startPos+1,endPos,k-1,positionStepMap);
            steps=(takeLeft + takeRight)%mod;
        }
        if(!positionStepMap.containsKey(startPos)){
            positionStepMap.put(startPos,new HashMap<>());
        }
        
        positionStepMap.get(startPos).put(k,steps);
        return steps;
    }
}