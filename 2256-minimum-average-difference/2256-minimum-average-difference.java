class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for(int n:nums){
            sum+=n;
        }
        
        int index = -1;
        int minDiff = Integer.MAX_VALUE;
        
        long leftSum = 0;
        
        for(int i=0;i<nums.length;i++){
            int leftCount = i+1;
            int rightCount = nums.length - i - 1;
            sum -= nums[i];
            leftSum += nums[i];
            
            long leftAverage = leftSum/leftCount;
            long rightAverage = rightCount>0? (sum/rightCount) : 0;
            
            long currentDiff = Math.abs(leftAverage  - rightAverage);
            if(currentDiff<minDiff){
                minDiff = (int)currentDiff;
                index = i;
            }
        }
        return index;
    }
}