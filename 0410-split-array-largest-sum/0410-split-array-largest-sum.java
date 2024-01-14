class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int sum =0;
        
        for(int n:nums){
            l = Math.max(l,n);
            sum+=n;
        }
        
        r= sum;
        int smallest_sum = l;
        while(l<=r){
            int mid = l + (r-l)/2;
            
            int subarr_count = split(nums,mid);
            if(subarr_count>k){
                l = mid+1;
            }else{
                r = mid-1;
                if(subarr_count==k){
                    smallest_sum=mid;
                }
            }
            
        }
        
        return smallest_sum;
    }
    
    public int split(int[] nums, int limit){
        int count = 1;
        int sum = 0;
        
        for(int n:nums){
            sum+=n;
            
            if(sum>limit){
                sum = n;
                count++;
            }
        }
        return count;
    }
}