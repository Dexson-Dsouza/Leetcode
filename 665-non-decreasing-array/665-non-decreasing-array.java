class Solution {
    public boolean checkPossibility(int[] nums) {
        return check(nums,1);
    }
    
    boolean check(int[] nums, int moves){
        if(moves<0){
            return false;
        }
        int i=1;
        
        while(i<nums.length){
            if(nums[i]<nums[i-1]){
                int second=nums[i];
                int first=nums[i-1];
                nums[i]=first;
                boolean canMake=false;
                canMake |= check(nums,moves-1);
                nums[i]=second;
                nums[i-1]=second;
                canMake |= check(nums,moves-1);
                nums[i-1]=first;
                nums[i]=second;
                return canMake;
            }
            i++;
        }
        
        return true;
    }
}