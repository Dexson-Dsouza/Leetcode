class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxPair = 0;
        
        for(int i=0;i<nums.length/2;i++){
            maxPair = Math.max(maxPair, nums[i] + nums[nums.length-1-i]);
        }
        return maxPair;
    }
}