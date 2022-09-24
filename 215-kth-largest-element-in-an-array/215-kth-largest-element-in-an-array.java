class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    
    public int quickSelect(int[] nums, int l, int r, int k){
        if(l>r){
            return nums[0];
        }
        int pivot = findPivot(nums,l,r);
        if(pivot==k){
            return nums[pivot];
        }
        
        if(pivot<k){
            return quickSelect(nums,pivot+1,r,k);
        }else{
            return quickSelect(nums,l,pivot-1,k);
        }
    }
    
    int findPivot(int[] nums, int l, int r){
        int n=nums[r];
        int index=l;
        while(l<r){
            if(nums[l]<=n){
                int t=nums[l];
                nums[l]=nums[index];
                nums[index]=t;
                index++;
            }
            l++;
        }
        int t=nums[index];
        nums[index]=n;
        nums[r]=t;
        return index;
    }
}