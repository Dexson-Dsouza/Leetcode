class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> handCount=new TreeMap<>();
        for(Integer curHand:hand){
            handCount.put(curHand,handCount.getOrDefault(curHand,0)+1);
        }
        
        List<Integer> keys=new ArrayList(handCount.keySet());
        for(Integer curHand:keys){
            if(handCount.get(curHand)==0){
                continue;
            }
            int curCount=handCount.get(curHand);
            handCount.put(curHand,handCount.get(curHand)-curCount);
            for(int i=1;i<=groupSize-1;i++){
                Integer nextHand=curHand+i;
                if(handCount.containsKey(nextHand)==false || handCount.get(nextHand)<curCount){
                    return false;
                }
                handCount.put(nextHand,handCount.get(nextHand)-curCount);
            }
        }
        return true;
    }
}