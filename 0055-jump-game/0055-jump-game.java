class Solution {
    public boolean canJump(int[] nums) {
        int curPos = 0;
        int maxJump = 0;
        while(curPos<=maxJump && maxJump<nums.length){
            maxJump = Math.max(maxJump,curPos + nums[curPos]);
            curPos++;
        }
        return maxJump>=nums.length-1;
    }
}