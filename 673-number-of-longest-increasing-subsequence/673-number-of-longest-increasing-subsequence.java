class Solution {
    public int findNumberOfLIS(int[] nums) {
        int inputSize=nums.length;
        
        int[] seqSize=new int[inputSize];
        int[] countOfSeq=new int[inputSize];
        int maxLen=0;
        
        for(int index=0;index<inputSize;index++){
            seqSize[index]=1;
            countOfSeq[index]=1;
            for(int start=0;start<index;start++){
                if(nums[index]>nums[start]){
                    if(seqSize[start]+1>seqSize[index]){
                        seqSize[index]=seqSize[start]+1;
                        countOfSeq[index]=countOfSeq[start];
                    }else if(seqSize[start]+1==seqSize[index]){
                        countOfSeq[index]+=countOfSeq[start];
                    }
                }
            }
            // System.out.println(seqSize[index]+" "+countOfSeq[index]);
            maxLen=Math.max(maxLen,seqSize[index]);
        }
        
        int countOfMaxLenSeq=0;
        for(int index=0;index<inputSize;index++){
            if(seqSize[index]==maxLen){
                countOfMaxLenSeq+=countOfSeq[index];
            }
        }
        
        return countOfMaxLenSeq;
    }
}