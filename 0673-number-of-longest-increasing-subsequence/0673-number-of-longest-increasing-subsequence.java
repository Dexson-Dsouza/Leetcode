class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] longestSeqArr = new int[n];
        int[] seqCountArr = new int[n];
        
        Arrays.fill(longestSeqArr,1);
        Arrays.fill(seqCountArr,1);
        
        int longestSeqLen = 1;
        
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    
                    int curSeqLen = longestSeqArr[j] + 1;
            
                    int prevLongestSoFar = longestSeqArr[i];
                    
                    if(curSeqLen>prevLongestSoFar){
                        longestSeqArr[i] = curSeqLen;
                        seqCountArr[i] = seqCountArr[j];
                    }else if(curSeqLen == prevLongestSoFar){
                        seqCountArr[i] += seqCountArr[j];
                    }
                    
                }
            }
            longestSeqLen = Math.max(longestSeqLen,longestSeqArr[i]);
        }
        
        int count = 0;
        for(int i = 0;i<n;i++){
            if(longestSeqArr[i]==longestSeqLen ){
                count += seqCountArr[i];
            }
        }
        return count;
    }
}