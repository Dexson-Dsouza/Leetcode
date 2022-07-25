class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left=0;
        int right=Integer.MAX_VALUE;
        int length=nums.length;
        
        int diff=0;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            int start=0;
            int end=start+1;
            int count=0;
            while(start<length){
                while(end<length && nums[end]-nums[start]<=mid){
                    end++;
                }
                count+=(end-start-1);
                start++;
            }
            // System.out.println(mid+" "+count);
            if(count>=k){
                right=mid-1;
                diff=mid;
                
            }else{
                left=mid+1;
            }
            
        }
        return diff;
    }
}