class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for(int n:nums){
            rightSum+=n;
        }
        
        int[] result = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            
            int rightCount = nums.length-i-1;
            int rightAbsSum = rightSum - rightCount*nums[i];
            
            int leftCount = i;
            int LeftAbsSum = leftCount*nums[i] - leftSum;
            
            leftSum += nums[i];
            result[i] = rightAbsSum+LeftAbsSum;
        }
        return result;
    }
}