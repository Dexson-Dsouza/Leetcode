class Solution {
    public int jump(int[] nums) {
        int curEnd = 0;
        int maxJump = 0;
        int steps = 0;
        for(int i = 0; i<nums.length-1; i++){
            maxJump = Math.max(maxJump, i + nums[i]);
            if(curEnd == i){
                steps++;
                curEnd = maxJump;
            }
        }
        return steps;
    }
}