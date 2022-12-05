class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findWays(0,nums,target);
    }
    
    int findWays(int i, int[] nums, int target){
        if(i==nums.length){
            return target==0?1:0;
        }
        return findWays(i+1,nums,target-nums[i])+ findWays(i+1,nums,target+nums[i]);
    }
}