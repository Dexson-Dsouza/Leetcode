class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int maxLen=0;
        int[] seq=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            seq[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    seq[i] = Math.max(seq[i],1+seq[j]);
                }
            }
            maxLen=Math.max(maxLen,seq[i]);
        }
        return maxLen;
    }
}