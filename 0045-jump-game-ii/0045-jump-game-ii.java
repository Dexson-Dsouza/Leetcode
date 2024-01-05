class Solution {
    public int jump(int[] nums) {
        int maxDist = 0;
        int index = 0;
        int curEnd = 0;
        int steps = 0;
        while(index<nums.length && curEnd<nums.length-1){
            maxDist = Math.max(maxDist,nums[index] + index);
            if(curEnd==index){
                curEnd = maxDist;
                steps++;
            }
            index++;
        }
        return steps;
    }
}