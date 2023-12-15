class Solution {
    public int findMin(int[] nums) {
        int small = Integer.MAX_VALUE;
        
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<=nums[r]){
                small = Math.min(small,nums[mid]);
                r=mid-1;
            }else{
                small = Math.min(small,nums[l]);
                l=mid+1;
            }
        }
        return small;
    }
}