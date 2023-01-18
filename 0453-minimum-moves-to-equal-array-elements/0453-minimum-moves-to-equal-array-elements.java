class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int n:nums){
            count += n-nums[0];
        }
        return count;
    }
}