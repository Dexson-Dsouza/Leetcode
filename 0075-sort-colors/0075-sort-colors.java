class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        
        for(int i=0;i<nums.length && i<=right;i++){
            if(nums[i]==0){
                int t=nums[left];
                nums[left]=0;
                nums[i]=t;
                left++;
            }else
            if(nums[i]==2){
                int t=nums[right];
                nums[right]=2;
                nums[i]=t;
                i--;
                right--;
            }
        }
        while(left<right){
            nums[left]=1;
            left++;
        }
    }
}