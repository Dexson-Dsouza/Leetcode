class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int index=0;
        
        while(index<=r){
            if(nums[index]==2){
                int t=nums[r];
                nums[r]=2;
                nums[index]=t;
                r--;
            }else if(nums[index]==0){
                int t=nums[l];
                nums[l]=0;
                nums[index]=t;
                l++;
                index++;
            }else{
                index++;
            }
        }
    }
}