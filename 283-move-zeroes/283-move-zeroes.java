class Solution {
    public void moveZeroes(int[] nums) {
        int cur=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[cur++]=nums[i];
            }
        }
        while(cur<nums.length){
            nums[cur++]=0;
        }
    }
}