class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        for(int num: nums){
            sum+=num;
            sum=Math.max(sum,num);
            max=Math.max(sum,max);
        }
        return max;
    }
}