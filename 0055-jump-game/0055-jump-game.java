class Solution {
    public boolean canJump(int[] nums) {
        int end=nums[0];
        
        int i=0;
        while(i<=end && end<nums.length-1){
            end=Math.max(end,i+nums[i]);
            i++;
        }
        return end>=nums.length-1;
    }
}