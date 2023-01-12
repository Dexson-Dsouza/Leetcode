class Solution {
    public int jump(int[] nums) {
        int len = nums.length-1;
        if(len==0){
            return 0;
        }
        int maxJump = 0;
        int index = 0;
        int count = 0;
        for(int i=0;i<=len-1;i++){
            maxJump=Math.max(maxJump,nums[i]+i);
            
            if(index == i){
                count++;
                index=maxJump;
            }
        }
        return count;
    }
}