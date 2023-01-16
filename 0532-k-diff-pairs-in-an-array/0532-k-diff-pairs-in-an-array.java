class Solution {
    public int findPairs(int[] nums, int k) {
    
        int count = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int x : nums)
                countMap.put(x,countMap.getOrDefault(x,0)+1);

        for(int x:countMap.keySet()){    
            if(countMap.containsKey(x-k) && k!=0){
                count++;
            }else if(k==0 && countMap.get(x)>1){
                count++;
            }
        }
        return count;
    }
}