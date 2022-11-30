class Solution {
    public boolean checkPossibility(int[] nums) {
        return check(nums,1);
    }
    
    boolean check(int[] nums, int movesLeft){
        int len = nums.length;
        int i=0;
        while(i<len-1){
            if(nums[i]>nums[i+1]){
                
                if(movesLeft==0){
                    return false;
                }
                
                int first=nums[i];
                int second=nums[i+1];
                
                // try increase smaller element
                nums[i+1]=first;
                if(check(nums,movesLeft-1)==true){
                    return true;
                }
                nums[i+1]=second;
                    
                //try decrease larger element
                nums[i]=second;
                if(check(nums,movesLeft-1)==true){
                    return true;
                }
                nums[i]=first;
                
                return false;
            }
            i++;
        }
        return true;
    }
}