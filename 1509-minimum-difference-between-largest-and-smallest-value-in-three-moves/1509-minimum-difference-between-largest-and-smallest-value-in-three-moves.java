class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        
        return getSmallest(nums,0,nums.length-1,3);
    }
    
    int getSmallest(int[] nums, int l, int r, int moves){
        if(l>r){
            return 0;
        }
        if(moves==0){
            return nums[r]-nums[l];
        }
        
        return Math.min(getSmallest(nums,l+1,r,moves-1),getSmallest(nums,l,r-1,moves-1));
    }
}