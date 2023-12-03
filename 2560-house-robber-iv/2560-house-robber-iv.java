class Solution {
    public int minCapability(int[] nums, int k) {
        int l=0;
        int r=Integer.MAX_VALUE;
        
        int minCap = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int[] count=new int[nums.length+1];
            for(int i=1;i<=nums.length;i++){
                if(nums[i-1]<=mid){
                    int prevCount = ((i-2)>=0)?count[i-2]:0;
                    count[i]=Math.max(count[i-1],1+prevCount);
                }else{
                    count[i]=count[i-1];
                }
            }
            if(count[nums.length]>=k){
                r=mid-1;
                minCap = mid;
            }else{
                l=mid+1;
            }
        }
        return minCap;
    }
}