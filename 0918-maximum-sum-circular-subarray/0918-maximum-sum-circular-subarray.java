class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int largestSum=Integer.MIN_VALUE;
        int smallestSum=Integer.MAX_VALUE;
        int totalSum=0;
        int curSmallest=0;
        int curLargest=0;
        
        for(int n:nums){
            if(n>=n+curLargest){
                curLargest=n;
            }else{
                curLargest+=n;
            }
            
            if(n<n+curSmallest){
                curSmallest=n;
            }else{
                curSmallest+=n;
            }
            
            largestSum=Math.max(largestSum,curLargest);
            smallestSum=Math.min(smallestSum,curSmallest);
            totalSum+=n;
        }
        // System.out.println(totalSum +" "+largestSum+" "+smallestSum);
        return Math.max(smallestSum!=totalSum?totalSum-smallestSum:totalSum,largestSum);
    }
}