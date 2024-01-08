class Solution {
    public int jump(int[] nums) {
        int curMax=0;
        int curPos=0;
        int maxReach=0;
        int jumps = 0;
        for(int i=0;i<nums.length-1;i++){
            curMax = Math.max(curMax,nums[i]+i);
            if(curPos == i){
                jumps++;
                curPos = curMax;
            }
        }
        
        return curPos>=nums.length-1?jumps:-1;
    }
}