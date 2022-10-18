class Solution {
    public int jump(int[] nums) {
        int inputSize=nums.length;
        int jumps=0;
        int curIndex=0;
        int farthest=0;
        for(int i=0;i<inputSize-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            
            if(curIndex == i){
                jumps++;
                curIndex=farthest;
            }
        }
        return jumps;
    }
}