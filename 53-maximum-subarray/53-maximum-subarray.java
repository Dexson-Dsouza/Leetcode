class Solution {
    public int maxSubArray(int[] nums) {
        int cs=0;
        int largestSum=Integer.MIN_VALUE;
        for(int n:nums){
            if(n>=cs+n){
                cs=n;
            }else{
                cs+=n;
            }
            largestSum=Math.max(largestSum,cs);
            
        }
        return largestSum;
    }
}