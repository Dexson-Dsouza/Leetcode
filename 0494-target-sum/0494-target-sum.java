class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer,Integer> countMap=new HashMap<>();
        countMap.put(0,1);
        
        for(int n:nums){
            Map<Integer,Integer> nextMap=new HashMap<>();
            for(int key : new ArrayList<>(countMap.keySet())){
                int curNum = key;
                int numOfWays = countMap.get(key);
                int decreasedVal = curNum - n;
                nextMap.put(decreasedVal, nextMap.getOrDefault(decreasedVal,0) + numOfWays);
                int increasedVal = curNum + n;
                nextMap.put(increasedVal, nextMap.getOrDefault(increasedVal,0) + numOfWays);
            }
            countMap = nextMap;
        }
        return countMap.getOrDefault(target,0);
    }
    
}