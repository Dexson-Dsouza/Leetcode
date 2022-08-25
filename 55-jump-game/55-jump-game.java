class Solution {
    public boolean canJump(int[] nums) {
        int curIndex=0;
        int len=nums.length;
        for(int i=0;i<len && curIndex>=i;i++){
            curIndex=Math.max(curIndex,i+nums[i]);
        }
        return curIndex>=len-1;
    }
}