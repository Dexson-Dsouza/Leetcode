class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer,Map<Integer,Integer>> indexSequenceMap=new HashMap<>();
        
        int inputLength=nums.length;
        
        int longestSeq=0;
        
        for(int i=0;i<inputLength;i++){
            Map<Integer,Integer> curSeqMap=new HashMap<>();
            curSeqMap.put(0,1);
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                Map<Integer,Integer> prevIndexSeqMap = indexSequenceMap.get(j);
                int prevLen=curSeqMap.getOrDefault(diff,0);
                curSeqMap.put(diff,Math.max(prevLen, Math.max(1 +  prevIndexSeqMap.getOrDefault(diff,0),2)));
                longestSeq=Math.max(longestSeq,curSeqMap.get(diff));
            }
            
            indexSequenceMap.put(i,curSeqMap);
        }
        return longestSeq;
    }
}