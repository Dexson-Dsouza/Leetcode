class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> numMap=new HashMap<>();
        int pairCount = 0;
        for(int n:nums){
            numMap.put(n,numMap.getOrDefault(n,0)+1);
        }
        
        for(int n:numMap.keySet()){
            int prevPair = n - k;
            if(k>0 && numMap.containsKey(prevPair)){
                pairCount++;
            }else if(k==0 && numMap.get(n)>1){
                pairCount++;
            }
        }
        return pairCount;
    }
}