class Solution {
    public int missingNumber(int[] nums) {
        for(int n:nums){
            int index = n;
            while(index>=0 && index<nums.length){
                int nextIndex=nums[index];
                nums[index]=-1;
                index=nextIndex;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                return i;
            }
        }
        return nums.length;
    }
}