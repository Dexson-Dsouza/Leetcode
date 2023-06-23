class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer,Map<Integer,Integer>> indexSequenceMap=new HashMap<>();
        int longestSeqResult = 0;
        for(int i = 0;i<nums.length;i++){
            Map<Integer,Integer> currentSeqMap = new HashMap<>();
            for(int j = i-1;j>=0;j--){
                int diff = nums[i] - nums[j];
                Map<Integer,Integer> prevIndexMap = indexSequenceMap.get(j);
                
                int curSeqLen = 1 + prevIndexMap.getOrDefault(diff,0);
                int prevSeqLen = currentSeqMap.getOrDefault(diff,0);
                int longestSeq = Math.max(curSeqLen,prevSeqLen);
                currentSeqMap.put(diff,longestSeq);
                longestSeqResult = Math.max(longestSeqResult,longestSeq);
            }
            
            indexSequenceMap.put(i,currentSeqMap);
        }
        return longestSeqResult+1;
    }
}