class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start=0;
        int end=0;
        int count=1;
        int len=nums.length;
        int maxLen=0;
        while(end<len){
            if(nums[end]==0){
                count--;
            }
            
            while(count<0){
                if(nums[start]==0){
                    count++;
                }
                start++;
            }
            
            maxLen=Math.max(end-start+1,maxLen);
            end++;
        }
        return maxLen;
    }
}